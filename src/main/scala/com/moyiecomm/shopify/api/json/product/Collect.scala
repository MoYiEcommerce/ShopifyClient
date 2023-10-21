package com.moyiecomm.shopify.api.json.product

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.syntax._

import java.time.ZonedDateTime

case class Collect(
    id: Long,
    position: Int,
    sortValue: String,
    collectionId: Long,
    productId: Long,
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Collect extends CirceConfig {
  case class ProductToCollection(productId: Long, collectionId: Long)

  val productToCollectionEncoder: Encoder[ProductToCollection] = new Encoder[ProductToCollection] {
    override def apply(p2c: ProductToCollection): Json = Json.obj(
      ("collect", p2c.asJson(deriveConfiguredEncoder))
    )
  }

  val collectDecoder: Decoder[Collect] = new Decoder[Collect] {
    override def apply(c: HCursor): Result[Collect] = c.get[Collect]("collect")(deriveConfiguredDecoder)
  }

  val collectListDecoder: Decoder[List[Collect]] = {
    implicit val collectDecoder: Decoder[Collect] = deriveConfiguredDecoder[Collect]
    new Decoder[List[Collect]] {
      override def apply(c: HCursor): Result[List[Collect]] =
        c.get[List[Collect]]("collects")
    }
  }
}
