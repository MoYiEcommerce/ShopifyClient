package com.moyiecomm.shopify.api.v1.products.models

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.v1.products.models.Collection.CollectionImage
import com.moyiecomm.shopify.api.v1.products.models.SmartCollection.Rule
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class SmartCollection(
    id: Option[Long],
    title: String,
    bodyHtml: Option[String],
    handle: Option[String],
    image: Option[CollectionImage],
    publishedScope: Option[String],
    rules: List[Rule],
    disjunctive: Boolean,
    sortOrder: Option[String],
    templateSuffix: Option[String],
    publishedAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object SmartCollection extends CirceConfig {
  case class Rule(column: String, relation: String, condition: String)

  implicit val ruleEncoder: Encoder[Rule] = deriveConfiguredEncoder[Rule]
  implicit val ruleDecoder: Decoder[Rule] = deriveConfiguredDecoder[Rule]

  val smartCollectionEncoder: Encoder[SmartCollection] = new Encoder[SmartCollection] {
    override def apply(a: SmartCollection): Json = Json.obj(
      (
        "smart_collection",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString
      )
    )
  }

  val smartCollectionDecoder: Decoder[SmartCollection] = new Decoder[SmartCollection] {
    override def apply(c: HCursor): Result[SmartCollection] = c.get[SmartCollection]("smart_collection")(deriveConfiguredDecoder)
  }

  val smartCollectionListDecoder: Decoder[List[SmartCollection]] = {
    implicit val smartCollectionDecoder: Decoder[SmartCollection] = deriveConfiguredDecoder[SmartCollection]
    new Decoder[List[SmartCollection]] {
      override def apply(c: HCursor): Result[List[SmartCollection]] =
        c.get[List[SmartCollection]]("smart_collections")
    }
  }
}
