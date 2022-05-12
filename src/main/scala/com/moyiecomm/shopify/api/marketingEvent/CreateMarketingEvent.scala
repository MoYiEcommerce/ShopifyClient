package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent.{marketingEventDecoder, marketingEventEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateMarketingEvent(marketingEvent: MarketingEvent)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[MarketingEvent, MarketingEvent](marketingEvent)(marketingEventEncoder, marketingEventDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/marketing_events.json"
}
