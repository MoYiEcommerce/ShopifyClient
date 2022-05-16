package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class AppliedDiscount(title: Option[String], description: Option[String], value: String, valueType: String, amount: Double)

object AppliedDiscount extends CirceConfig {
  implicit val appliedDiscountEncoder: Encoder[AppliedDiscount] = deriveConfiguredEncoder[AppliedDiscount]
  implicit val appliedDiscountDecoder: Decoder[AppliedDiscount] = deriveConfiguredDecoder[AppliedDiscount]
}
