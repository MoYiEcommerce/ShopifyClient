package com.moyiecomm.shopify.api.events

import com.moyiecomm.shopify.api.events.models.Event
import com.moyiecomm.shopify.api.events.models.Event.eventDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetEventById(eventId: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Event]()(eventDecoder) {
  override def path: String = s"/events/$eventId.json"
}
