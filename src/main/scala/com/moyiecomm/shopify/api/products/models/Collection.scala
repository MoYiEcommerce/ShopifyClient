package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class Collection(
    id: Option[Long],
    title: String,
    bodyHtml: Option[String],
    handle: Option[String],
    image: Option[CollectionImage],
    publishedScope: Option[String],
    sortOrder: Option[String],
    templateSuffix: Option[String],
    publishedAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Collection extends CirceConfig {
  case class CollectionImage(
      attachment: Array[Byte],
      src: String,
      alt: Option[String],
      createAt: Option[ZonedDateTime],
      width: Int,
      height: Int
  )

  implicit val collectionImageEncoder: Encoder[CollectionImage] = deriveConfiguredEncoder[CollectionImage]

  implicit val collectionImageDecoder: Decoder[CollectionImage] = deriveConfiguredDecoder[CollectionImage]

  implicit val customCollectionEncoder: Encoder[Collection] = new Encoder[Collection] {
    override def apply(a: Collection): Json = Json.obj(
      ("custom_collection", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues)
    )
  }

  implicit val collectionDecoder: Decoder[Collection] = new Decoder[Collection] {
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
