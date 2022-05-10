package com.moyiecomm.shopify.api.events.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.ZonedDateTime

case class WebHook(
    id: Option[Long],
    address: String,
    apiVersion: Option[String],
    fields: List[String],
    format: String,
    topic: String,
    metafieldNamespaces: List[String],
    privateMetafieldNamespaces: List[String],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object WebHook extends CirceConfig {
  val webHookEncoder: Encoder[WebHook] = new Encoder[WebHook] {
    override def apply(a: WebHook): Json = Json.obj(
      (
        "webhook",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
      )
    )
  }

  val webHookDecoder: Decoder[WebHook] = new Decoder[WebHook] {
    override def apply(c: HCursor): Result[WebHook] = c.get[WebHook]("webhook")(deriveConfiguredDecoder)
  }

  val webHookListDecoder: Decoder[List[WebHook]] = {
    implicit val webHookDecoder: Decoder[WebHook] = deriveConfiguredDecoder[WebHook]
    new Decoder[List[WebHook]] {
      override def apply(c: HCursor): Result[List[WebHook]] = c.get[List[WebHook]]("webhooks")
    }
  }
}
