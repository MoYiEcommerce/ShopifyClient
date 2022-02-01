package com.moyiecomm.shopify.api.onlineStore

import com.moyiecomm.shopify.api.onlineStore.Article.Image

case class Article(
    author: String,
    blogId: Long,
    bodyHtml: String,
    created_at: Long,
    id: Long,
    handle: String,
    image: Image,
    metafields: Metafield,
    published: Boolean,
    publishedAt: Long,
    summaryHtml: String,
    tags: String,
    templateSuffix: String,
    title: String,
    updatedAt: Long,
    userId: Long
)

object Article {
  case class Image(src: String, createdAt: Long)

}
