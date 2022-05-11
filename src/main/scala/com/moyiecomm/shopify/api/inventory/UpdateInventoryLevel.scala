package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.InventoryLevel
import com.moyiecomm.shopify.api.inventory.models.InventoryLevel.{inventoryLevelDecoder, inventoryLevelEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateInventoryLevel(inventoryLevel: InventoryLevel)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[InventoryLevel, InventoryLevel](inventoryLevel)(inventoryLevelEncoder, inventoryLevelDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/inventory_levels/set.json"
}
