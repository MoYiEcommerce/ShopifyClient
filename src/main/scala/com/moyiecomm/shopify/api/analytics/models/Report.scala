package com.moyiecomm.shopify.api.analytics.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class Report(
    id: Option[Long],
    category: Option[String],
    name: String,
    shopifyQl: String,
    updatedAt: Option[ZonedDateTime]
)

object Report extends CirceConfig {
  val reportEncoder: Encoder[Report] = new Encoder[Report] {
    override def apply(a: Report): Json = Json.obj(
      ("report", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString)
    )
  }

  val reportDecoder: Decoder[Report] = new Decoder[Report] {
    override def apply(c: HCursor): Result[Report] =
      c.get[Report]("report")(deriveConfiguredDecoder)
  }

  val reportListDecoder: Decoder[List[Report]] = {
    implicit val reportDecoder: Decoder[Report] = deriveConfiguredDecoder[Report]
    new Decoder[List[Report]] {
      override def apply(c: HCursor): Result[List[Report]] = c.get[List[Report]]("reports")
    }
  }
}
