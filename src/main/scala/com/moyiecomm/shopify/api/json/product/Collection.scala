package com.moyiecomm.shopify.api.json.product

import java.time.ZonedDateTime

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.json.product.Collection.CollectionImage
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class Collection(
    id: Option[Long],
    title: String,
    bodyHtml: Option[String],
    handle: Option[String],
    image: Option[CollectionImage],
    publishedScope: Option[String],
    published: Option[Boolean],
    sortOrder: Option[String],
    templateSuffix: Option[String],
    productsCount: Option[Int],
    publishedAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Collection extends CirceConfig {
  case class CollectionImage(
      attachment: Option[Array[Byte]],
      src: String,
      alt: Option[String],
      createdAt: Option[ZonedDateTime],
      width: Int,
      height: Int
  )

  implicit val collectionImageEncoder: Encoder[CollectionImage] = deriveConfiguredEncoder[CollectionImage]
  implicit val collectionImageDecoder: Decoder[CollectionImage] = deriveConfiguredDecoder[CollectionImage]

  val customCollectionEncoder: Encoder[Collection] = new Encoder[Collection] {
    override def apply(a: Collection): Json = Json.obj(
      (
        "custom_collection",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder[Collection])).dropNullValues.dropEmptyValues
      )
    )
  }
  val customCollectionListDecoder: Decoder[List[Collection]] = {
    new Decoder[List[Collection]] {
      override def apply(c: HCursor): Result[List[Collection]] =
        c.get[List[Collection]]("custom_collections")(Decoder.decodeList(deriveConfiguredDecoder[Collection]))
    }
  }

  val collectionDecoder: Decoder[Collection] = new Decoder[Collection] {
    override def apply(c: HCursor): Result[Collection] = {
      Seq(
        c.downField("collection").focus,
        c.downField("custom_collection").focus,
        c.downField("smart_collection").focus
      ).flatten.headOption match {
        case Some(json) =>
          json.as[Collection](deriveConfiguredDecoder)
        case None =>
          Left(DecodingFailure("Can't find field 'collection' or 'custom_collection' or 'smart_collection'", List.empty))
      }
    }
  }
}
