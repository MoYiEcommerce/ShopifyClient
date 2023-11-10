package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.json.CustomizedBaseTypeEncoder
import com.moyiecomm.shopify.api.json.CustomizedCollectionCodec
import io.circe._
import io.circe.generic.extras.semiauto._

case class LineItem(
    id: Option[Long],
    custom: Option[Boolean],
    name: Option[String],
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
    vendor: Option[String],
    giftCard: Option[Boolean],
    properties: List[NoteAttribute],
    appliedDiscount: Option[AppliedDiscount],
    taxLines: List[TaxLine],
    taxable: Option[Boolean]
)

object LineItem extends CirceConfig with CustomizedBaseTypeEncoder with CustomizedCollectionCodec {
  implicit val lineItemEncoder: Encoder[LineItem] = deriveConfiguredEncoder[LineItem].mapJson(
    _.dropEmptyValues.dropNullValues.dropEmptyString.deepDropNullValues.deepDropEmptyString
  )
  implicit val lineItemDecoder: Decoder[LineItem] = deriveConfiguredDecoder[LineItem]
}
