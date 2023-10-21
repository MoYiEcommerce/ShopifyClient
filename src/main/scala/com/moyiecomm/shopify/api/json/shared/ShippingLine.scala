package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class ShippingLine(code: String, price: Double, source: String, title: Option[String])

object ShippingLine extends CirceConfig {
  implicit val shippingLineEncoder: Encoder[ShippingLine] =
    deriveConfiguredEncoder[ShippingLine].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)
  implicit val shippingLineDecoder: Decoder[ShippingLine] = deriveConfiguredDecoder[ShippingLine]
}
