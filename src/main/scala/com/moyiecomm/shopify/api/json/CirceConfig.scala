package com.moyiecomm.shopify.api.json

import io.circe.Json
import io.circe.JsonNumber
import io.circe.JsonObject
import io.circe.generic.extras.Configuration

trait CirceConfig {
  implicit val customConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  implicit class ExtendedJson(jsObject: Json) {
    def dropEmptyString: Json = jsObject.mapObject(_.filter { case (_, v) =>
      v match {
        case v if v.isString => v.asString.exists(_.nonEmpty)
        case _               => true
      }
    })

    def dropField(filedName: String): Json = jsObject.mapObject(_.filter { case (k, _) => k != filedName })

    def deepDropEmptyString: Json = {
      val folder = new Json.Folder[Json] {
        def onNull: Json                      = Json.Null
        def onBoolean(value: Boolean): Json   = Json.fromBoolean(value)
        def onNumber(value: JsonNumber): Json = Json.fromJsonNumber(value)
        def onString(value: String): Json = {
          if (value.nonEmpty) {
            Json.fromString(value)
          } else {
            Json.Null
          }
        }
        def onArray(value: Vector[Json]): Json =
          Json.fromValues(value.collect {
            case v if !v.isNull => v.foldWith(this)
          })
        def onObject(value: JsonObject): Json =
          Json.fromJsonObject(
            value.filter { case (_, v) => !v.isNull }.mapValues(_.foldWith(this))
          )
      }

      jsObject.foldWith(folder)
    }
  }
}
