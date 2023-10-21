package com.moyiecomm.shopify.api.v1.marketingEvent

import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent.marketingEventDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetMarketingEventById(marketingEventId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[MarketingEvent]()(marketingEventDecoder) {
  override def path: String = s"/marketing_events/$marketingEventId.json"
}
