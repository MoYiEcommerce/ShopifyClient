package com.moyiecomm.shopify.api.v1.storeProperties

case class Country(
    code: String,
    id: Long,
    provinces: List[Province],
    tax: Float
)
