package com.moyiecomm.shopify.api.v1.products.models

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.v1.shared.models.ProductOption
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class Product(
    id: Option[Long],
    title: String,
    bodyHtml: Option[String],
    handle: Option[String],
    vendor: Option[String],
    images: List[ProductImage],
    options: List[ProductOption],
    productType: String,
    publishedScope: Option[String],
    status: Option[String],
    tags: Option[String],
    templateSuffix: Option[String],
    variants: List[ProductVariant],
    createdAt: Option[ZonedDateTime],
    publishedAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Product extends CirceConfig {

  val productEncoder: Encoder[Product] = {
    implicit val variantEncoder: Encoder[ProductVariant]    = deriveConfiguredEncoder[ProductVariant]
    implicit val productImageEncoder: Encoder[ProductImage] = deriveConfiguredEncoder[ProductImage]
    new Encoder[Product] {
      override def apply(a: Product): Json = Json.obj(
        (
          "product",
          Json
            .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
            .dropNullValues
            .dropEmptyValues
        )
      )
    }
  }

  val productDecoder: Decoder[Product] = {
    implicit val variantDecoder: Decoder[ProductVariant]    = deriveConfiguredDecoder[ProductVariant]
    implicit val productImageDecoder: Decoder[ProductImage] = deriveConfiguredDecoder[ProductImage]
    new Decoder[Product] {
      override def apply(c: HCursor): Result[Product] = {
        c.get[Product]("product")(deriveConfiguredDecoder)
      }
    }
  }

  val productListDecoder: Decoder[List[Product]] = {
    implicit val variantDecoder: Decoder[ProductVariant]    = deriveConfiguredDecoder[ProductVariant]
    implicit val productImageDecoder: Decoder[ProductImage] = deriveConfiguredDecoder[ProductImage]
    implicit val productDecoder: Decoder[Product]           = deriveConfiguredDecoder[Product]
    new Decoder[List[Product]] {
      override def apply(c: HCursor): Result[List[Product]] = {
        c.get[List[Product]]("products")
      }
    }
  }
}
