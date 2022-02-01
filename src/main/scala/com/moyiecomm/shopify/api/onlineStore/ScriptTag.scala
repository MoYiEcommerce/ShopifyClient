package com.moyiecomm.shopify.api.onlineStore

case class ScriptTag(
    createdAt: Long,
    event: String,
    id: Long,
    src: String,
    displayScope: String,
    cache: Boolean,
    updatedAt: Long
)
