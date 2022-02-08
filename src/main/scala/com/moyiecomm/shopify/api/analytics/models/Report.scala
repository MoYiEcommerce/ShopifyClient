package com.moyiecomm.shopify.api.analytics.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class Report(
    category: String,
    id: Long,
    name: String,
    shopifyQl: String,
    updateAt: Long
)

object Report extends CirceConfig {
  implicit val reportEncoder: Encoder[Report] = new Encoder[Report] {
    override def apply(a: Report): Json = Json.obj(
      ("report", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val reportDecoder: Decoder[Report] = new Decoder[Report] {
    override def apply(c: HCursor): Result[Report] =
      c.get[Report]("report")(deriveConfiguredDecoder)
  }
}
