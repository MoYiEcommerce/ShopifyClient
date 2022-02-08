package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

case class RecurringApplicationCharge(
    activatedOn: Long,
    billingOn: Long,
    cancelledOn: Long,
    cappedAmount: String,
    confirmationUrl: String,
    createAt: Long,
    id: Long,
    name: String,
    price: Long,
    returnUrl: String,
    status: String,
    terms: String,
    test: Boolean,
    trialDays: Int,
    trialEndsOn: Long,
    updateAt: Long
)

object RecurringApplicationCharge extends CirceConfig {
  implicit val applicationCreditEncoder: Encoder[RecurringApplicationCharge] = new Encoder[RecurringApplicationCharge] {
    override def apply(a: RecurringApplicationCharge): Json = Json.obj(
      ("recurring_application_charge", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val applicationCreditDecoder: Decoder[RecurringApplicationCharge] = new Decoder[RecurringApplicationCharge] {
    override def apply(c: HCursor): Result[RecurringApplicationCharge] =
      c.get[RecurringApplicationCharge]("recurring_application_charge")(deriveConfiguredDecoder)
  }
}
