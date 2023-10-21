package com.moyiecomm.shopify.api.v1.salesChannels

import com.moyiecomm.shopify.api.v1.products.models.ProductVariant
import com.moyiecomm.shopify.api.v1.shared.models.ProductOption

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
