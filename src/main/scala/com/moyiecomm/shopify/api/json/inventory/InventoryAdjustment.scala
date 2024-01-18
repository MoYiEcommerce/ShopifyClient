package com.moyiecomm.shopify.api.json.inventory

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class InventoryAdjustment(availableAdjustment: Option[Int], inventoryItemId: Long, locationId: Long)

object InventoryAdjustment extends CirceConfig {
  val inventoryAdjustmentEncoder: Encoder[InventoryAdjustment] =
    deriveConfiguredEncoder[InventoryAdjustment].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)
}
