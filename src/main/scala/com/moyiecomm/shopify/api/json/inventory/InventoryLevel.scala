package com.moyiecomm.shopify.api.json.inventory

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class InventoryLevel(
    available: Int,
    inventoryItemId: Long,
    locationId: Long,
    updatedAt: Option[ZonedDateTime]
)

object InventoryLevel extends CirceConfig {
  val inventoryLevelEncoder: Encoder[InventoryLevel] =
    deriveConfiguredEncoder[InventoryLevel].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)

  val inventoryLevelDecoder: Decoder[InventoryLevel] = new Decoder[InventoryLevel] {
    override def apply(c: HCursor): Result[InventoryLevel] = c.get[InventoryLevel]("inventory_level")(deriveConfiguredDecoder)
  }

  val inventoryLevelListDecoder: Decoder[List[InventoryLevel]] = {
    implicit val inventoryLevelDecoder: Decoder[InventoryLevel] = deriveConfiguredDecoder[InventoryLevel]
    new Decoder[List[InventoryLevel]] {
      override def apply(c: HCursor): Result[List[InventoryLevel]] = c.get[List[InventoryLevel]]("inventory_levels")
    }
  }
}
