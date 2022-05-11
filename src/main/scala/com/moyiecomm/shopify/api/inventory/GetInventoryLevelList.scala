package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.InventoryLevel
import com.moyiecomm.shopify.api.inventory.models.InventoryLevel.inventoryLevelListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetInventoryLevelList(inventoryItemIds: List[Long], locationIds: List[Long])(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[InventoryLevel]]()(inventoryLevelListDecoder) {
  override def path: String = {
    require(inventoryItemIds.nonEmpty || locationIds.nonEmpty, "inventory item ids or location ids can't be empty")
    val parameters = (inventoryItemIds.nonEmpty, locationIds.nonEmpty) match {
      case (true, false) => s"inventory_item_ids=${inventoryItemIds.mkString(",")}"
      case (false, true) => s"location_ids=${locationIds.mkString(",")}"
      case (true, true) =>
        Seq(s"inventory_item_ids=${inventoryItemIds.mkString(",")}", s"location_ids=${locationIds.mkString(",")}")
          .mkString("&")
    }
    Seq("/inventory_levels.json", parameters).mkString("?")
  }
}
