package com.moyiecomm.shopify.api.inventory

case class Location(
    active: Boolean,
    address1: String,
    address2: String,
    city: String,
    country: String,
    countryCode: String,
    createdAt: Long,
    id: Long,
    legacy: Boolean,
    name: String,
    phone: String,
    province: String,
    provinceCode: String,
    updatedAt: Long,
    zip: String,
    localizedCountryName: String,
    localizedProvinceName: String
)
