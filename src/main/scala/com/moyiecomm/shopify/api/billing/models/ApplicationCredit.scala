package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

case class ApplicationCredit(
    description: String,
    id: Long,
    amount: Int,
    test: Boolean
)

object ApplicationCredit extends CirceConfig {
  implicit val applicationCreditEncoder: Encoder[ApplicationCredit] = new Encoder[ApplicationCredit] {
    override def apply(a: ApplicationCredit): Json = Json.obj(
      ("application_credit", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val applicationCreditDecoder: Decoder[ApplicationCredit] = new Decoder[ApplicationCredit] {
    override def apply(c: HCursor): Result[ApplicationCredit] =
      c.get[ApplicationCredit]("application_credit")(deriveConfiguredDecoder)
  }
}
