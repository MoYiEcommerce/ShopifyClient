package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryItem
import io.circe.Decoder

case class GetInventoryItemById(inventoryItemId: Long, override val config: Config) extends GetRequest[InventoryItem](config) {

  override val path: String                            = s"inventory_items/$inventoryItemId.json"
  override val responseDecoder: Decoder[InventoryItem] = InventoryItem.inventoryItemDecoder
}
