package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

case class UsageCharge(
    createAt: Long,
    description: String,
    id: Long,
    price: String,
    recurringApplicationChargeId: Long,
    updateAt: Long
)

object UsageCharge extends CirceConfig {
  implicit val applicationCreditEncoder: Encoder[UsageCharge] = new Encoder[UsageCharge] {
    override def apply(a: UsageCharge): Json = Json.obj(
      ("usage_charge", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val applicationCreditDecoder: Decoder[UsageCharge] = new Decoder[UsageCharge] {
    override def apply(c: HCursor): Result[UsageCharge] =
      c.get[UsageCharge]("usage_charge")(deriveConfiguredDecoder)
  }
}
