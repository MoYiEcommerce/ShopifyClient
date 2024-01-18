package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.Event
import io.circe.Decoder

case class GetEventById(eventId: Long, override val config: Config) extends GetRequest[Event](config) {
  override val path: String                    = s"events/$eventId.json"
  override val responseDecoder: Decoder[Event] = Event.eventDecoder
}
