package com.moyiecomm.shopify.api.v1.inventory.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.generic.extras.semiauto._
import io.circe._

case class InventoryAdjustment(availableAdjustment: Option[Int], inventoryItemId: Long, locationId: Long)

object InventoryAdjustment extends CirceConfig {
  val inventoryAdjustmentEncoder: Encoder[InventoryAdjustment] =
    deriveConfiguredEncoder[InventoryAdjustment].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)
}
