package com.moyiecomm.shopify.api.access

case class StorefrontAccessToken(
    id: Long,
    accessToken: String,
    accessScope: String,
    createdAt: Long,
    title: String
)
