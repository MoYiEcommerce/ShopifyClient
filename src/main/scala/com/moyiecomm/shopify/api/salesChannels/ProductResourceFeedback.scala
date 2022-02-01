package com.moyiecomm.shopify.api.salesChannels

case class ProductResourceFeedback(
    createdAt: Long,
    updatedAt: Long,
    resourceId: Long,
    resourceType: String,
    state: String,
    messages: List[String],
    feedbackGeneratedAt: Long,
    resourceUpdatedAt: Long
)
