package com.moyiecomm.shopify.api.inventory

case class InventoryLevel(
    available: Int,
    inventoryItemId: Long,
    locationId: Long,
    updatedAt: Long
)
