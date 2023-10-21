package com.moyiecomm.shopify.api.v1.marketingEvent

import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent.marketingEventListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetMarketingEventList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[MarketingEvent]]()(marketingEventListDecoder) {
  override def path: String = "/marketing_events.json"
}
