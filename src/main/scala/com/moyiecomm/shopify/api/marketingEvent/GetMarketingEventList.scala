package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent.marketingEventListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetMarketingEventList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[MarketingEvent]]()(marketingEventListDecoder) {
  override def path: String = "/marketing_events.json"
}
