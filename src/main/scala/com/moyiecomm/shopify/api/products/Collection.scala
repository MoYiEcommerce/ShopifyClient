package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.Collection.CollectionImage

case class Collection(
    bodyHtml: String,
    handle: String,
    image: CollectionImage,
    id: Long,
    publishedAt: Long,
    publishedScope: String,
    sortOrder: String,
    templateSuffix: String,
    title: String,
    updateAt: Long
)

object Collection {
  case class CollectionImage(
      attachment: Array[Byte],
      src: String,
      alt: String,
      createAt: Long,
      width: Int,
      height: Int
  )
}
