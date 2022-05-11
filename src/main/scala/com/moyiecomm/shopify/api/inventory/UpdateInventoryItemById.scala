package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.InventoryItem
import com.moyiecomm.shopify.api.inventory.models.InventoryItem.{inventoryItemDecoder, inventoryItemEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateInventoryItemById(inventoryItem: InventoryItem)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[InventoryItem, InventoryItem](inventoryItem)(inventoryItemEncoder, inventoryItemDecoder) {
  override def method: Method = Method.PUT

  override def path: String = s"/inventory_items/${inventoryItem.id}.json"
}
