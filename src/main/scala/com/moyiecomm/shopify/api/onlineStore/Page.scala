package com.moyiecomm.shopify.api.onlineStore

case class Page(
    author: String,
    bodyHtml: String,
    createdAt: Long,
    handle: String,
    id: Long,
    metafield: Metafield,
    publishedAt: Long,
    shopId: Long,
    templateSuffix: String,
    title: String,
    updatedAt: Long
)
