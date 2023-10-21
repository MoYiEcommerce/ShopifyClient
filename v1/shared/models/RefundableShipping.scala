package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.CustomizedBaseTypeEncoder
import com.moyiecomm.shopify.api.json.{CirceConfig, CustomizedBaseTypeEncoder}
import io.circe._
import io.circe.generic.extras.semiauto._

case class RefundableShipping(
    amount: Option[Double],
    tax: Option[Double],
    maximumRefundable: Option[Double],
    fullRefund: Option[Boolean]
)

object RefundableShipping extends CirceConfig with CustomizedBaseTypeEncoder {
  implicit val refundableShippingEncoder: Encoder[RefundableShipping] =
    deriveConfiguredEncoder[RefundableShipping].mapJson(_.dropEmptyValues.dropNullValues)
  implicit val refundableShippingDecoder: Decoder[RefundableShipping] = deriveConfiguredDecoder[RefundableShipping]
}
