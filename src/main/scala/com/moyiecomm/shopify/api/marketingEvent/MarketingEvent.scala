package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.marketingEvent.MarketingEvent.MarketedResources

case class MarketingEvent(
    remoteId: String,
    eventType: String,
    marketingChannel: String,
    paid: Boolean,
    referringDomain: String,
    budget: String,
    currency: String,
    budgetType: String,
    startedAt: Long,
    scheduledToEndAt: Long,
    endedAt: Long,
    description: String,
    manageUrl: String,
    previewUrl: String,
    marketedResources: List[MarketedResources]
)

object MarketingEvent {
  case class MarketedResources(id: Long, `type`: String)
}
