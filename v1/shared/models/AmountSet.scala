package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class AmountSet(shopMoney: Price, presentmentMoney: Price)

object AmountSet extends CirceConfig {
  implicit val amountSetEncoder: Encoder[AmountSet] = deriveConfiguredEncoder[AmountSet]
  implicit val amountSetDecoder: Decoder[AmountSet] = deriveConfiguredDecoder[AmountSet]
}
