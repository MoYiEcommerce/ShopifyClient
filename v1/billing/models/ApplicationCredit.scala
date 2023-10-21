package com.moyiecomm.shopify.api.v1.billing.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

case class ApplicationCredit(
    description: Option[String],
    id: Option[Long],
    amount: Double,
    test: Option[Boolean]
)

object ApplicationCredit extends CirceConfig {
  val applicationCreditEncoder: Encoder[ApplicationCredit] = new Encoder[ApplicationCredit] {
    override def apply(a: ApplicationCredit): Json = Json.obj(
      (
        "application_credit",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString
      )
    )
  }

  val applicationCreditDecoder: Decoder[ApplicationCredit] = new Decoder[ApplicationCredit] {
    override def apply(c: HCursor): Result[ApplicationCredit] =
      c.get[ApplicationCredit]("application_credit")(deriveConfiguredDecoder)
  }

  val applicationCreditListDecoder: Decoder[List[ApplicationCredit]] = {
    implicit val applicationChargeDecoder: Decoder[ApplicationCredit] = deriveConfiguredDecoder[ApplicationCredit]
    new Decoder[List[ApplicationCredit]] {
      override def apply(c: HCursor): Result[List[ApplicationCredit]] = c.get[List[ApplicationCredit]]("application_credits")
    }
  }
}
