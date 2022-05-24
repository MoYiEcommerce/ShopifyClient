package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class Receipt(testcase: Boolean, authorization: String)

object Receipt extends CirceConfig {
  implicit val receiptEncoder: Encoder[Receipt] = deriveConfiguredEncoder[Receipt]
  implicit val receiptDecoder: Decoder[Receipt] = deriveConfiguredDecoder[Receipt]
}
