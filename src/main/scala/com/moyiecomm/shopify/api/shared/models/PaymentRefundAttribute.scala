package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class PaymentRefundAttribute(status: String, acquirerReferenceNumber: String)

object PaymentRefundAttribute extends CirceConfig {
  implicit val paymentRefundAttributeEncoder: Encoder[PaymentRefundAttribute] = deriveConfiguredEncoder[PaymentRefundAttribute]
  implicit val paymentRefundAttributeDecoder: Decoder[PaymentRefundAttribute] = deriveConfiguredDecoder[PaymentRefundAttribute]
}
