package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.InventoryItem.CountryHarmonizedSystemCodes

case class InventoryItem(
    cost: String,
    countryCodeOfOrigin: String,
    countryHarmonizedSystemCodes: CountryHarmonizedSystemCodes,
    createdAt: Long,
    harmonizedSystemCode: String,
    id: Long,
    provinceCodeOfOrigin: String,
    sku: String,
    tracked: Boolean,
    updatedAt: Long,
    requiresShipping: Boolean
)

object InventoryItem {
  case class CountryHarmonizedSystemCodes(
      countryCode: String,
      harmonizedSystemCode: String
  )
}
