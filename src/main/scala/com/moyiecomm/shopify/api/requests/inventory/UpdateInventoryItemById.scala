package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryItem
import io.circe.{Decoder, Encoder}
import sttp.model.Method

case class UpdateInventoryItemById(inventoryItem: InventoryItem, override val config: Config)
    extends PutRequest[InventoryItem, InventoryItem](inventoryItem, config) {

  override val path: String                            = s"inventory_items/${inventoryItem.id}.json"
  override val requestEncoder: Encoder[InventoryItem]  = InventoryItem.inventoryItemEncoder
  override val responseDecoder: Decoder[InventoryItem] = InventoryItem.inventoryItemDecoder
}
