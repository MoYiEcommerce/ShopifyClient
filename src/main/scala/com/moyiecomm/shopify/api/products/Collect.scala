package com.moyiecomm.shopify.api.products

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
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime
)

object Collect extends CirceConfig {

  implicit val collectDecoder: Decoder[Collect] = new Decoder[Collect] {
    override def apply(c: HCursor): Result[Collect] = c.get[Collect]("collect")(deriveConfiguredDecoder)
  }
}
