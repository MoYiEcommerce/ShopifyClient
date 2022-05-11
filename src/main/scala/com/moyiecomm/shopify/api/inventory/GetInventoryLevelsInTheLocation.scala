package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.InventoryLevel
import com.moyiecomm.shopify.api.inventory.models.InventoryLevel.inventoryLevelListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetInventoryLevelsInTheLocation(locationId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[InventoryLevel]]()(inventoryLevelListDecoder) {
  override def path: String = s"/locations/$locationId/inventory_levels.json"
}
