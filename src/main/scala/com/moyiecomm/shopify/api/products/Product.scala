package com.moyiecomm.shopify.api.products

case class Product(
    bodyHtml: String,
    createAt: Long,
    handle: String,
    id: Long,
    images: List[ProductImage],
    options: List[ProductOption],
    productTYpe: String,
    publishedScope: String,
    status: String,
    tags: String,
    templateSuffix: String,
    title: String,
    updateAt: Long,
    variants: List[ProductVariant],
    vendor: String
)
