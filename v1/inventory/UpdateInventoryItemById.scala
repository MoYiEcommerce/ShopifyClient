package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem
import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem.{inventoryItemDecoder, inventoryItemEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateInventoryItemById(inventoryItem: InventoryItem)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[InventoryItem, InventoryItem](inventoryItem)(inventoryItemEncoder, inventoryItemDecoder) {
  override def method: Method = Method.PUT

  override def path: String = s"/inventory_items/${inventoryItem.id}.json"
}
