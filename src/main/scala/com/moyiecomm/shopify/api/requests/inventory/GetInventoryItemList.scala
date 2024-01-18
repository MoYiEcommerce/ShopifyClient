package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryItem
import io.circe.Decoder

case class GetInventoryItemList(inventoryItemIdList: List[Long], override val config: Config)
    extends GetRequest[List[InventoryItem]](config) {
  override val path: String = {
    require(inventoryItemIdList.nonEmpty, "inventory item id list can't be empty")
    val ids = inventoryItemIdList.mkString(",")
    s"inventory_items.json?ids=$ids"
  }
  override val responseDecoder: Decoder[List[InventoryItem]] = InventoryItem.inventoryItemListDecoder
}
