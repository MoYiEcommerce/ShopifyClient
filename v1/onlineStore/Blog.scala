package com.moyiecomm.shopify.api.v1.onlineStore

case class Blog(
    commentable: String,
    createdAt: Long,
    feedburner: String,
    feedburnerLocation: String,
    handle: String,
    id: Long,
    tags: String,
    templateSuffix: String,
    title: String,
    updatedAt: Long,
    adminGraphqlApiId: String
)
