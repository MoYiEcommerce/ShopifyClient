package com.moyiecomm.shopify.api.products

case class ProductOption(
    id: Long,
    productId: Long,
    position: Int,
    values: List[String]
)
