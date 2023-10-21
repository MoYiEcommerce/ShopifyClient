package com.moyiecomm.shopify.api.v1.storeProperties

import com.moyiecomm.shopify.api.v1.salesChannels.ShippingRate

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
