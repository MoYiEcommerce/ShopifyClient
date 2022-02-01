package com.moyiecomm.shopify.api.salesChannels

case class CollectionListing(
    collectionId: Long,
    bodyHtml: String,
    defaultProductImage: List[ImageSrc],
    image: List[ImageSrc],
    handle: String,
    publishedAt: Long,
    title: String,
    sortOrder: String,
    updateAt: Long
)
