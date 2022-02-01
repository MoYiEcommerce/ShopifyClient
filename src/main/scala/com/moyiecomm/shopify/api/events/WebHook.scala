package com.moyiecomm.shopify.api.events

case class WebHook(
    address: String,
    apiVersion: String,
    createdAt: Long,
    fields: List[String],
    format: String,
    id: Long,
    metafieldNamespaces: List[String],
    privateMetafieldNamespaces: List[String],
    topic: String,
    updatedAt: String
)
