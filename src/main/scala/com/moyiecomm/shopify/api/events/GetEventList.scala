package com.moyiecomm.shopify.api.events

import com.moyiecomm.shopify.api.events.models.Event
import com.moyiecomm.shopify.api.events.models.Event.eventListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetEventList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Event]]()(eventListDecoder) {
  override def path: String = "/events.json"
}
