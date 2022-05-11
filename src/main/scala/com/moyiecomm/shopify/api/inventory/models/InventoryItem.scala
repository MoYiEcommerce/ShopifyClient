package com.moyiecomm.shopify.api.inventory.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.shared.models.CountryHarmonizedSystemCode
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.ZonedDateTime

case class InventoryItem(
    id: Long,
    sku: Option[String],
    cost: Option[Double],
    countryCodeOfOrigin: Option[String],
    countryHarmonizedSystemCodes: List[CountryHarmonizedSystemCode],
    harmonizedSystemCode: Option[String],
    provinceCodeOfOrigin: Option[String],
    tracked: Option[Boolean],
    requiresShipping: Option[Boolean],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object InventoryItem extends CirceConfig {

  val inventoryItemEncoder: Encoder[InventoryItem] = new Encoder[InventoryItem] {
    override def apply(a: InventoryItem): Json = Json.obj(
      (
        "inventory_item",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .deepDropNullValues
          .dropEmptyString
      )
    )
  }

  val inventoryItemDecoder: Decoder[InventoryItem] = new Decoder[InventoryItem] {
    override def apply(c: HCursor): Result[InventoryItem] = c.get[InventoryItem]("inventory_item")(deriveConfiguredDecoder)
  }

  val inventoryItemListDecoder: Decoder[List[InventoryItem]] = {
    implicit val inventoryItemDecoder: Decoder[InventoryItem] = deriveConfiguredDecoder[InventoryItem]
    new Decoder[List[InventoryItem]] {
      override def apply(c: HCursor): Result[List[InventoryItem]] = c.get[List[InventoryItem]]("inventory_items")
    }
  }
}
