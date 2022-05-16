package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class LineItem(
    fulfillmentService: Option[String],
    fulfillmentStatus: Option[String],
    grams: Option[Int],
    price: Double,
    productId: Option[Long],
    quantity: Int,
    requiresShipping: Option[Boolean],
    sku: Option[String],
    title: Option[String],
    variantId: Option[Long],
    variantTitle: Option[String],
    vendor: Option[String]
)

object LineItem extends CirceConfig {
  implicit val lineItemEncoder: Encoder[LineItem] = deriveConfiguredEncoder[LineItem]
  implicit val lineItemDecoder: Decoder[LineItem] = deriveConfiguredDecoder[LineItem]
}
