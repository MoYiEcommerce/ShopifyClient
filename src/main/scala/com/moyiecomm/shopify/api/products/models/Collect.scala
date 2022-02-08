package com.moyiecomm.shopify.api.products.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, HCursor}
import io.circe.generic.extras.semiauto._

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
