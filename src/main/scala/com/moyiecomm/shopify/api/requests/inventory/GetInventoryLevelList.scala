package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.InventoryLevel
import io.circe.Decoder

case class GetInventoryLevelList(inventoryItemIds: List[Long], locationIds: List[Long], override val config: Config)
    extends GetRequest[List[InventoryLevel]](config) {
  override val path: String = {
    require(inventoryItemIds.nonEmpty || locationIds.nonEmpty, "inventory item ids or location ids can't be empty")
    val parameters = (inventoryItemIds.nonEmpty, locationIds.nonEmpty) match {
      case (true, false) => s"inventory_item_ids=${inventoryItemIds.mkString(",")}"
      case (false, true) => s"location_ids=${locationIds.mkString(",")}"
      case (true, true) =>
        Seq(s"inventory_item_ids=${inventoryItemIds.mkString(",")}", s"location_ids=${locationIds.mkString(",")}")
          .mkString("&")
      case (false, false) => ""
    }
    Seq("inventory_levels.json", parameters).mkString("?")
  }

  override val responseDecoder: Decoder[List[InventoryLevel]] = InventoryLevel.inventoryLevelListDecoder
}
