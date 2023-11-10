package com.moyiecomm.shopify.api.json.shared

import java.time.ZonedDateTime

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class PaymentSchedule(
    amount: Double,
    currency: String,
    issuedAt: Option[ZonedDateTime],
    dueAt: Option[ZonedDateTime],
    completedAt: Option[ZonedDateTime],
    expectedPaymentMethod: String
)

object PaymentSchedule extends CirceConfig {
  implicit val paymentScheduleEncoder: Encoder[PaymentSchedule] =
    deriveConfiguredEncoder[PaymentSchedule].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)
  implicit val paymentScheduleDecoder: Decoder[PaymentSchedule] = deriveConfiguredDecoder[PaymentSchedule]
}
