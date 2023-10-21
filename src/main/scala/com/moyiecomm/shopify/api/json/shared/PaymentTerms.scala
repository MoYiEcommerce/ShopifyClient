package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class PaymentTerms(
    amount: Double,
    currency: String,
    paymentTermsName: String,
    paymentTermsType: String,
    dueInDays: Int,
    paymentSchedules: List[PaymentSchedule]
)

object PaymentTerms extends CirceConfig {
  implicit val paymentTermEncoder: Encoder[PaymentTerms] =
    deriveConfiguredEncoder[PaymentTerms].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)
  implicit val paymentTermDecoder: Decoder[PaymentTerms] = deriveConfiguredDecoder[PaymentTerms]
}
