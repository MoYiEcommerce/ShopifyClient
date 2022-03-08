package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class ProductImage(
    id: Option[Long],
    filename: Option[String],
    alt: Option[String],
    position: Option[Int],
    productId: Long,
    variantIds: List[Long],
    src: Option[String],
    width: Option[Int],
    height: Option[Int],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime],
    attachment: Option[String]
)

object ProductImage extends CirceConfig {
  val productImageEncoder: Encoder[ProductImage] = new Encoder[ProductImage] {
    override def apply(a: ProductImage): Json = Json.obj(
      (
        "image",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropField("product_id")
      )
    )
  }

  val productImageDecoder: Decoder[ProductImage] = new Decoder[ProductImage] {
    override def apply(c: HCursor): Result[ProductImage] = {
      c.get[ProductImage]("image")(deriveConfiguredDecoder)
    }
  }

  val productImageListDecoder: Decoder[List[ProductImage]] = {
    implicit val productImageDecoder: Decoder[ProductImage] = deriveConfiguredDecoder[ProductImage]
    new Decoder[List[ProductImage]] {
      override def apply(c: HCursor): Result[List[ProductImage]] =
        c.get[List[ProductImage]]("images")
    }
  }
}
