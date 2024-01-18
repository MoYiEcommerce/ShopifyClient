package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeleteInventoryLevel(inventoryLevelId: Long, locationId: Long, override val config: Config)
    extends DeleteRequest(config) {
  override val path: String = s"inventory_levels.json?inventory_item_id=$inventoryLevelId&location_id=$locationId"
}
