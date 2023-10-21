package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class DiscountApplication(
    `type`: String,
    code: String,
    value: Double,
    valueType: String,
    allocationMethod: String,
    targetSelection: String,
    targetType: String
)

object DiscountApplication extends CirceConfig {
  implicit val discountApplicationEncoder: Encoder[DiscountApplication] = deriveConfiguredEncoder[DiscountApplication]
  implicit val discountApplicationDecoder: Decoder[DiscountApplication] = deriveConfiguredDecoder[DiscountApplication]
}
