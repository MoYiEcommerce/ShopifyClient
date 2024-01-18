package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.Event
import io.circe.Decoder

case class GetEventList(override val config: Config) extends GetRequest[List[Event]](config) {
  override val path: String                          = "events.json"
  override val responseDecoder: Decoder[List[Event]] = Event.eventListDecoder
}
