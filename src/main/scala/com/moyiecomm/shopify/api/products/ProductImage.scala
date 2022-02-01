package com.moyiecomm.shopify.api.products

case class ProductImage(
    createAt: Long,
    id: Long,
    position: Int,
    productId: Long,
    variantIds: List[Long],
    src: String,
    width: Int,
    height: Int,
    updateAt: Long
)
