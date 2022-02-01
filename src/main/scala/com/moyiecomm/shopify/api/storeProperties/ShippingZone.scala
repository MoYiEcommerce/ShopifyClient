package com.moyiecomm.shopify.api.storeProperties

import com.moyiecomm.shopify.api.salesChannels.ShippingRate

case class ShippingZone(
    id: Long,
    name: String,
    profileId: Long,
    locationGroupId: Long,
    countries: List[Country],
    provinces: List[Province],
    carrierShippingRateProviders: List[String],
    priceBasedShippingRates: ShippingRate,
    weightBasedShippingRates: ShippingRate
)
