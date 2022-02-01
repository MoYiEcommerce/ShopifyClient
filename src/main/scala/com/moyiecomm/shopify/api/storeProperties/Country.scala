package com.moyiecomm.shopify.api.storeProperties

case class Country(
    code: String,
    id: Long,
    provinces: List[Province],
    tax: Float
)
