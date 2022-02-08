package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class ProductImage(
    createAt: Long,
    id: Long,
    position: Int,
    productId: Long,
    variantIds: List[Long],
    src: String,
    width: Int,
    height: Int,
    updateAt: Long,
    attachment: Option[String]
)

object ProductImage extends CirceConfig {
  implicit val productImageEncoder: Encoder[ProductImage] = new Encoder[ProductImage] {
    override def apply(a: ProductImage): Json = Json.obj(
      ("image", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val productImageDecoder: Decoder[ProductImage] = new Decoder[ProductImage] {
    override def apply(c: HCursor): Result[ProductImage] = {
      c.get[ProductImage]("image")(deriveConfiguredDecoder)
    }
  }
}
