package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedBaseTypeEncoder}
import io.circe._
import io.circe.generic.extras.semiauto._

case class AppliedDiscount(title: Option[String], description: Option[String], value: String, valueType: String, amount: Double)

object AppliedDiscount extends CirceConfig with CustomizedBaseTypeEncoder {
  implicit val appliedDiscountEncoder: Encoder[AppliedDiscount] =
    deriveConfiguredEncoder[AppliedDiscount].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)
  implicit val appliedDiscountDecoder: Decoder[AppliedDiscount] = deriveConfiguredDecoder[AppliedDiscount]
}
