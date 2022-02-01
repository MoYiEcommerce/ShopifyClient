package com.moyiecomm.shopify.api.onlineStore

case class Comment(
    articleId: Long,
    author: String,
    blogId: Long,
    body: String,
    bodyHtml: String,
    createdAt: Long,
    email: String,
    id: Long,
    ip: String,
    publishedAt: Long,
    status: String,
    updatedAt: Long,
    userAgent: String
)
