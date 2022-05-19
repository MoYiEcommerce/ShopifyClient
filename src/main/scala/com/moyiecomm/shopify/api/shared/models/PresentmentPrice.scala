package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.semiauto._

case class PresentmentPrice(price: Price, compareAtPrice: Option[Price])

object PresentmentPrice extends CirceConfig {

  implicit val presentmentPriceEncoder: Encoder[PresentmentPrice] =
    deriveConfiguredEncoder[PresentmentPrice].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString.deepDropNullValues)
  implicit val presentmentPriceDecoder: Decoder[PresentmentPrice] = deriveConfiguredDecoder[PresentmentPrice]
}
