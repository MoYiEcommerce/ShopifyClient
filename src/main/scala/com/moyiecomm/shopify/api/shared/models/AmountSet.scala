package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class AmountSet(shopMoney: Price, presentmentMoney: Price)

object AmountSet extends CirceConfig {
  implicit val amountSetEncoder: Encoder[AmountSet] = deriveConfiguredEncoder[AmountSet]
  implicit val amountSetDecoder: Decoder[AmountSet] = deriveConfiguredDecoder[AmountSet]
}
