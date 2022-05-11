package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.InventoryAdjustment.inventoryAdjustmentEncoder
import com.moyiecomm.shopify.api.inventory.models.InventoryLevel.inventoryLevelDecoder
import com.moyiecomm.shopify.api.inventory.models.{InventoryAdjustment, InventoryLevel}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class ConnectInventoryItemWithLocation(inventoryAdjustment: InventoryAdjustment)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[InventoryAdjustment, InventoryLevel](inventoryAdjustment)(
      inventoryAdjustmentEncoder,
      inventoryLevelDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/inventory_levels/connect.json"
}
