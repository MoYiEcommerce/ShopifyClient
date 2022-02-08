package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.semiauto._

case class ProductOption(
    id: Long,
    productId: Long,
    position: Int,
    values: List[String]
)

object ProductOption extends CirceConfig {
  implicit val priceEncoder: Encoder[ProductOption] = deriveConfiguredEncoder[ProductOption]
  implicit val priceDecoder: Decoder[ProductOption] = deriveConfiguredDecoder[ProductOption]
}
