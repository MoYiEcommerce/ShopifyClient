package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.{InventoryAdjustment, InventoryLevel}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import InventoryLevel.inventoryLevelDecoder
import com.moyiecomm.shopify.api.v1.inventory.models.InventoryAdjustment.inventoryAdjustmentEncoder
import sttp.model.Method

case class UpdateInventoryLevelByLocationId(inventoryAdjustment: InventoryAdjustment)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[InventoryAdjustment, InventoryLevel](inventoryAdjustment)(
      inventoryAdjustmentEncoder,
      inventoryLevelDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/inventory_levels/adjust.json"
}
