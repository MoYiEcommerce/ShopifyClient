package com.moyiecomm.shopify.api.storeProperties

case class Province(
    code: String,
    countryId: Long,
    id: Long,
    name: String,
    shippingZoneId: Long,
    tax: Float,
    taxName: String,
    taxType: String,
    taxPercentage: Int
)
