package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryLevel
import io.circe.{Decoder, Encoder}

case class UpdateInventoryLevel(inventoryLevel: InventoryLevel, override val config: Config)
    extends PostRequest[InventoryLevel, InventoryLevel](inventoryLevel, config) {

  override val path: String                             = "inventory_levels/set.json"
  override val requestEncoder: Encoder[InventoryLevel]  = InventoryLevel.inventoryLevelEncoder
  override val responseDecoder: Decoder[InventoryLevel] = InventoryLevel.inventoryLevelDecoder
}
