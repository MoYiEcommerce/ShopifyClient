package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem
import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem.inventoryItemDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetInventoryItemById(inventoryItemId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[InventoryItem]()(inventoryItemDecoder) {
  override def path: String = s"/inventory_items/$inventoryItemId.json"
}
