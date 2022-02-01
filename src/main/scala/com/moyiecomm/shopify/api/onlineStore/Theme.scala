package com.moyiecomm.shopify.api.onlineStore

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
