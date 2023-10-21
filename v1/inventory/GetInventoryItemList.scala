package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem
import com.moyiecomm.shopify.api.v1.inventory.models.InventoryItem.inventoryItemListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetInventoryItemList(inventoryItemIdList: List[Long])(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[InventoryItem]]()(inventoryItemListDecoder) {
  override def path: String = {
    require(inventoryItemIdList.nonEmpty, "inventory item id list can't be empty")
    val ids = inventoryItemIdList.mkString(",")
    s"/inventory_items.json?ids=$ids"
  }
}
