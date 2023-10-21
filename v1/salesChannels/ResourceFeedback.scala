package com.moyiecomm.shopify.api.v1.salesChannels

case class ResourceFeedback(
    createdAt: Long,
    updatedAt: Long,
    resourceId: Long,
    state: String,
    messages: List[String],
    feedbackGeneratedAt: Long
)
