package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.semiauto._

case class Price(amount: String, currencyCode: String)

object Price extends CirceConfig {
  implicit val priceEncoder: Encoder[Price] =
    deriveConfiguredEncoder[Price].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)
  implicit val priceDecoder: Decoder[Price] = deriveConfiguredDecoder[Price]
}
