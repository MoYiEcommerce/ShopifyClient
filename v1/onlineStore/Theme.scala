package com.moyiecomm.shopify.api.v1.onlineStore

case class Theme(
    created_at: Long,
    id: Long,
    name: String,
    previewable: Boolean,
    processing: Boolean,
    role: String,
    themeStoreId: Long,
    updatedAt: Long
)
