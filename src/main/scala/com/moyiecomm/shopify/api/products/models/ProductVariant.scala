package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.shared.models.PresentmentPrice
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class ProductVariant(
    id: Option[Long],
    barcode: Option[String],
    compareAtPrice: Option[String],
    createdAt: Option[ZonedDateTime],
    fulfillmentService: Option[String],
    grams: Option[Int],
    imageId: Option[Long],
    inventoryItemId: Option[Long],
    inventoryManagement: Option[String],
    inventoryPolicy: Option[String],
    inventoryQuantity: Option[Int],
    option1: Option[String],
    option2: Option[String],
    option3: Option[String],
    presentmentPrices: List[PresentmentPrice],
    position: Option[Int],
    price: String,
    productId: Long,
    sku: Option[String],
    taxable: Boolean,
    taxCode: Option[String],
    updatedAt: Option[ZonedDateTime],
    weight: Option[Double],
    weightUnit: Option[String]
) {
  val title: String = Seq(option1, option2, option3).flatten.mkString("/")
}

object ProductVariant extends CirceConfig {

  val productVariantEncoder: Encoder[ProductVariant] = new Encoder[ProductVariant] {
    override def apply(a: ProductVariant): Json = Json.obj(
      (
        "variant",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropField("product_id")
      )
    )
  }

  val productVariantDecoder: Decoder[ProductVariant] = new Decoder[ProductVariant] {
    override def apply(c: HCursor): Result[ProductVariant] = {
      c.get[ProductVariant]("variant")(deriveConfiguredDecoder)
    }
  }

  val productVariantListDecoder: Decoder[List[ProductVariant]] = {
    implicit val productVariantDecoder = deriveConfiguredDecoder[ProductVariant]
    new Decoder[List[ProductVariant]] {
      override def apply(c: HCursor): Result[List[ProductVariant]] = {
        c.get[List[ProductVariant]]("variants")
      }
    }
  }
}
