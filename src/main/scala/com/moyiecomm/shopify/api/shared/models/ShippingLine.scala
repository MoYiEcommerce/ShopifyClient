package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class ShippingLine(code: String, price: Double, source: String, title: Option[String])

object ShippingLine extends CirceConfig {
  implicit val shippingLineEncoder: Encoder[ShippingLine] = deriveConfiguredEncoder[ShippingLine]
  implicit val shippingLineDecoder: Decoder[ShippingLine] = deriveConfiguredDecoder[ShippingLine]
}
