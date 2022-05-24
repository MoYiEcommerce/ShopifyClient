package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class PaymentDetail(
    creditCardBin: Option[String],
    avsResultCode: Option[String],
    cvvResultCode: Option[String],
    creditCardNumber: String,
    creditCardCompany: String
)

object PaymentDetail extends CirceConfig {
  implicit val paymentDetailEncoder: Encoder[PaymentDetail] =
    deriveConfiguredEncoder[PaymentDetail].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)

  implicit val paymentDetailDecoder: Decoder[PaymentDetail] = deriveConfiguredDecoder[PaymentDetail]
}
