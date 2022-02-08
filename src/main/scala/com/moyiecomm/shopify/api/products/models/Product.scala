package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class Product(
    bodyHtml: String,
    createAt: Long,
    handle: String,
    id: Long,
    images: List[ProductImage],
    options: List[ProductOption],
    productTYpe: String,
    publishedScope: String,
    status: String,
    tags: String,
    templateSuffix: String,
    title: String,
    updateAt: Long,
    variants: List[ProductVariant],
    vendor: String
)

object Product extends CirceConfig {

  implicit val productEncoder: Encoder[Product] = new Encoder[Product] {
    override def apply(a: Product): Json = Json.obj(
      ("product", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val productDecoder: Decoder[Product] = new Decoder[Product] {
    override def apply(c: HCursor): Result[Product] = {
      c.get[Product]("product")(deriveConfiguredDecoder)
    }
  }
}
