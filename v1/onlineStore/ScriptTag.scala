package com.moyiecomm.shopify.api.v1.onlineStore

case class ScriptTag(
    createdAt: Long,
    event: String,
    id: Long,
    src: String,
    displayScope: String,
    cache: Boolean,
    updatedAt: Long
)
