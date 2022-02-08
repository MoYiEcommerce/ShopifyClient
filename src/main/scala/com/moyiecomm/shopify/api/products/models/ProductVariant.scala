package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.others.Price
import com.moyiecomm.shopify.api.products.models.ProductVariant.PresentmentPrice
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class ProductVariant(
    barcode: String,
    compareAtPrice: String,
    createAt: Long,
    fulfillmentService: String,
    grams: Int,
    id: Long,
    imageId: Long,
    inventoryItemId: Long,
    inventoryManagement: String,
    inventoryPolicy: String,
    inventoryQuantity: Int,
    option1: String,
    option2: String,
    option3: String,
    presentmentPrice: List[PresentmentPrice],
    position: Int,
    price: String,
    productId: Long,
    sku: String,
    taxable: Boolean,
    taxCode: String,
    title: String,
    updateAt: Long,
    weight: Int,
    weightUnit: String
)

object ProductVariant extends CirceConfig {
  case class PresentmentPrice(price: Price, compareAtPrice: Price)

  implicit val presentmentPriceEncoder: Encoder[PresentmentPrice] = deriveConfiguredEncoder[PresentmentPrice]
  implicit val presentmentPriceDecoder: Decoder[PresentmentPrice] = deriveConfiguredDecoder[PresentmentPrice]

  implicit val productVariantEncoder: Encoder[ProductVariant] = new Encoder[ProductVariant] {
    override def apply(a: ProductVariant): Json = Json.obj(
      ("variant", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val productVariantDecoder: Decoder[ProductVariant] = new Decoder[ProductVariant] {
    override def apply(c: HCursor): Result[ProductVariant] = {
      c.get[ProductVariant]("variant")(deriveConfiguredDecoder)
    }
  }
}
