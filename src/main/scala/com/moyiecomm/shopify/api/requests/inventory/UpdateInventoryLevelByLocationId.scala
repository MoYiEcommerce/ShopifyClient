package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.{InventoryAdjustment, InventoryLevel}
import io.circe.{Decoder, Encoder}

case class UpdateInventoryLevelByLocationId(inventoryAdjustment: InventoryAdjustment, override val config: Config)
    extends PostRequest[InventoryAdjustment, InventoryLevel](inventoryAdjustment, config) {

  override val path: String                                 = "inventory_levels/adjust.json"
  override val requestEncoder: Encoder[InventoryAdjustment] = InventoryAdjustment.inventoryAdjustmentEncoder
  override val responseDecoder: Decoder[InventoryLevel]     = InventoryLevel.inventoryLevelDecoder
}
