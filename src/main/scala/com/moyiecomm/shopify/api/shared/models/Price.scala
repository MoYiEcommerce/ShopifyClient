package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.semiauto._

case class Price(amount: String, currencyCode: String)

object Price extends CirceConfig {
  implicit val priceEncoder: Encoder[Price] = deriveConfiguredEncoder[Price]
  implicit val priceDecoder: Decoder[Price] = deriveConfiguredDecoder[Price]
}
