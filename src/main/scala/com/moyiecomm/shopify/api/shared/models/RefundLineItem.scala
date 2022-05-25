package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class RefundLineItem(lineItemId: Long, quantity: Int, restockType: String, locationId: Option[Long])

object RefundLineItem extends CirceConfig {
  implicit val refundLineItemEncoder: Encoder[RefundLineItem] = deriveConfiguredEncoder[RefundLineItem]
  implicit val refundLineItemDecoder: Decoder[RefundLineItem] = deriveConfiguredDecoder[RefundLineItem]
}
