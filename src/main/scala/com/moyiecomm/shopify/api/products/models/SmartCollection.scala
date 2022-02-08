package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage
import com.moyiecomm.shopify.api.products.models.SmartCollection.Rule
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class SmartCollection(
    bodyHtml: String,
    handle: String,
    image: CollectionImage,
    id: Long,
    publishedAt: Long,
    publishedScope: String,
    rules: List[Rule],
    disjunctive: Boolean,
    sortOrder: String,
    templateSuffix: String,
    title: String,
    updateAt: Long
)

object SmartCollection extends CirceConfig {
  case class Rule(column: String, relation: String, condition: String)

  implicit val ruleEncoder: Encoder[Rule] = deriveConfiguredEncoder[Rule]
  implicit val ruleDecoder: Decoder[Rule] = deriveConfiguredDecoder[Rule]

  implicit val smartCollectionEncoder: Encoder[SmartCollection] = new Encoder[SmartCollection] {
    override def apply(a: SmartCollection): Json = Json.obj(
      ("smart_collection", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val smartCollectionDecoder: Decoder[SmartCollection] = new Decoder[SmartCollection] {
    override def apply(c: HCursor): Result[SmartCollection] = c.get[SmartCollection]("smart_collection")(deriveConfiguredDecoder)
  }
}
