package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.shared.models.Status
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

import java.time.{LocalDate, ZonedDateTime}

case class RecurringApplicationCharge(
    activatedOn: Option[LocalDate],
    apiClientId: Option[Long],
    billingOn: Option[LocalDate],
    cancelledOn: Option[LocalDate],
    cappedAmount: Option[Double],
    confirmationUrl: Option[String],
    decoratedReturnUrl: Option[String],
    createdAt: Option[ZonedDateTime],
    id: Option[Long],
    name: String,
    price: Double,
    returnUrl: Option[String],
    status: Option[Status],
    terms: Option[String],
    test: Option[Boolean],
    trialDays: Option[Int],
    trialEndsOn: Option[LocalDate],
    updatedAt: Option[ZonedDateTime],
    balanceUsed: Option[Double],
    balanceRemaining: Option[Double],
    riskLevel: Option[Int],
    updateCappedAmountUrl: Option[String]
)

object RecurringApplicationCharge extends CirceConfig {
  val recurringApplicationChargeEncoder: Encoder[RecurringApplicationCharge] = new Encoder[RecurringApplicationCharge] {
    override def apply(a: RecurringApplicationCharge): Json = Json.obj(
      (
        "recurring_application_charge",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString
      )
    )
  }

  val recurringApplicationChargeDecoder: Decoder[RecurringApplicationCharge] = new Decoder[RecurringApplicationCharge] {
    override def apply(c: HCursor): Result[RecurringApplicationCharge] =
      c.get[RecurringApplicationCharge]("recurring_application_charge")(deriveConfiguredDecoder)
  }

  val recurringApplicationChargeListDecoder: Decoder[List[RecurringApplicationCharge]] = {
    implicit val recurringApplicationChargeDecoder: Decoder[RecurringApplicationCharge] =
      deriveConfiguredDecoder[RecurringApplicationCharge]
    new Decoder[List[RecurringApplicationCharge]] {
      override def apply(c: HCursor): Result[List[RecurringApplicationCharge]] =
        c.get[List[RecurringApplicationCharge]]("recurring_application_charges")
    }
  }
}
