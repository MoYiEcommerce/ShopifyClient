package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

import java.time.{LocalDate, ZonedDateTime}

case class UsageCharge(
    createdAt: Option[ZonedDateTime],
    description: String,
    id: Option[Long],
    price: Double,
    recurringApplicationChargeId: Option[Long],
    updatedAt: Option[ZonedDateTime],
    billingOn: Option[LocalDate],
    balanceUsed: Option[Double],
    balanceRemaining: Option[Double],
    riskLevel: Option[Int]
)

object UsageCharge extends CirceConfig {
  val usageChargeEncoder: Encoder[UsageCharge] = new Encoder[UsageCharge] {
    override def apply(a: UsageCharge): Json = Json.obj(
      (
        "usage_charge",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
          .dropField("recurring_application_charge_id")
      )
    )
  }

  val usageChargeDecoder: Decoder[UsageCharge] = new Decoder[UsageCharge] {
    override def apply(c: HCursor): Result[UsageCharge] =
      c.get[UsageCharge]("usage_charge")(deriveConfiguredDecoder)
  }

  val usageChargeListDecoder: Decoder[List[UsageCharge]] = {
    implicit val usageChargeDecoder: Decoder[UsageCharge] = deriveConfiguredDecoder[UsageCharge]
    new Decoder[List[UsageCharge]] {
      override def apply(c: HCursor): Result[List[UsageCharge]] = c.get[List[UsageCharge]]("usage_charges")
    }
  }
}
