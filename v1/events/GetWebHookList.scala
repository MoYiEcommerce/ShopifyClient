package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.events.models.WebHook
import com.moyiecomm.shopify.api.v1.events.models.WebHook.webHookListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetWebHookList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[WebHook]]()(webHookListDecoder) {
  override def path: String = "/webhooks.json"
}
