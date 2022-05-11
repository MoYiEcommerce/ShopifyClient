package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteInventoryLevel(inventoryLevelId: Long, locationId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest {
  override def path: String = s"/inventory_levels.json?inventory_item_id=$inventoryLevelId&location_id=$locationId"
}
