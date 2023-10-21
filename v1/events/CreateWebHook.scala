package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.events.models.WebHook
import com.moyiecomm.shopify.api.v1.events.models.WebHook.{webHookDecoder, webHookEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateWebHook(webHook: WebHook)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[WebHook, WebHook](webHook)(webHookEncoder, webHookDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/webhooks.json"
}
