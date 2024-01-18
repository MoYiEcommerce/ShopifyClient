package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryLevel
import io.circe.Decoder

case class GetInventoryLevelsInTheLocation(locationId: Long, override val config: Config)
    extends GetRequest[List[InventoryLevel]](config) {

  override val path: String                                   = s"locations/$locationId/inventory_levels.json"
  override val responseDecoder: Decoder[List[InventoryLevel]] = InventoryLevel.inventoryLevelListDecoder
}
