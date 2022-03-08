package com.moyiecomm.shopify.api

import io.circe.Json
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
  }
}
