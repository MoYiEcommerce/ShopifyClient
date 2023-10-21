package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder}

case class ProductOption(
    id: Long,
    productId: Long,
    name: String,
    position: Int,
    values: List[String]
)

object ProductOption extends CirceConfig {
  implicit val priceEncoder: Encoder[ProductOption] =
    deriveConfiguredEncoder[ProductOption].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)
  implicit val priceDecoder: Decoder[ProductOption] = deriveConfiguredDecoder[ProductOption]
}
