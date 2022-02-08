package com.moyiecomm.shopify.api.salesChannels

import com.moyiecomm.shopify.api.products.models.{ProductOption, ProductVariant}

case class ProductListing(
    productId: Long,
    bodyHtml: String,
    createdAt: Long,
    handle: String,
    images: List[ImageSrc],
    options: List[ProductOption],
    productType: String,
    publishedAt: Long,
    tags: String,
    title: String,
    updatedAt: Long,
    variants: List[ProductVariant],
    vendor: String
)
