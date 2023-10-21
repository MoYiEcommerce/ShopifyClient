package com.moyiecomm.shopify.api.v1.marketingEvent

import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent
import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent.{marketingEventDecoder, marketingEventEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateMarketingEventById(marketingEvent: MarketingEvent)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[MarketingEvent, MarketingEvent](marketingEvent)(marketingEventEncoder, marketingEventDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(marketingEvent.id.nonEmpty, "The Id of market event can't be empty")
    s"/marketing_events/${marketingEvent.id.getOrElse("")}.json"
  }
}
