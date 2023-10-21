package com.moyiecomm.shopify.api.v1.onlineStore

case class Asset(
    attachment: String,
    checksum: String,
    contentType: String,
    createdAt: Long,
    key: String,
    publicUrl: String,
    size: Long,
    themeId: Long,
    updatedAt: Long,
    value: String
)
