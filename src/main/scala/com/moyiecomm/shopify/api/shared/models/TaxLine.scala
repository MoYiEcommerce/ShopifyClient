package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class TaxLine(price: Double, rate: Double, title: Option[String], channelLiable: Option[String])

object TaxLine extends CirceConfig {
  implicit val taxLineEncoder: Encoder[TaxLine] = deriveConfiguredEncoder[TaxLine]
  implicit val taxLineDecoder: Decoder[TaxLine] = deriveConfiguredDecoder[TaxLine]
}
