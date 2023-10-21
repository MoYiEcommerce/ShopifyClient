package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.events.models.WebHook
import com.moyiecomm.shopify.api.v1.events.models.WebHook.webHookDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetWebHookById(webhookId: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[WebHook]()(webHookDecoder) {
  override def path: String = s"/webhooks/$webhookId.json"
}
