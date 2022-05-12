package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent.marketingEventDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetMarketingEventById(marketingEventId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[MarketingEvent]()(marketingEventDecoder) {
  override def path: String = s"/marketing_events/$marketingEventId.json"
}
