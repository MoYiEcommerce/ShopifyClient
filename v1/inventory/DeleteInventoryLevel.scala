package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteInventoryLevel(inventoryLevelId: Long, locationId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest {
  override def path: String = s"/inventory_levels.json?inventory_item_id=$inventoryLevelId&location_id=$locationId"
}
