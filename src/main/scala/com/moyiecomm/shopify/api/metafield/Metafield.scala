package com.moyiecomm.shopify.api.metafield

case class Metafield(
    createdAt: Long,
    updatedAt: Long,
    description: String,
    id: Long,
    key: String,
    namespace: String,
    ownerId: Long,
    ownerResource: String,
    value: String,
    `type`: String
)
