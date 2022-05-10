package com.moyiecomm.shopify.api.events

import com.moyiecomm.shopify.api.events.models.WebHook
import com.moyiecomm.shopify.api.events.models.WebHook.webHookListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetWebHookList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[WebHook]]()(webHookListDecoder) {
  override def path: String = "/webhooks.json"
}
