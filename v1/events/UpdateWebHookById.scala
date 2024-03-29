package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.events.models.WebHook
import com.moyiecomm.shopify.api.v1.events.models.WebHook.{webHookDecoder, webHookEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateWebHookById(webHook: WebHook)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[WebHook, WebHook](webHook)(webHookEncoder, webHookDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(webHook.id.nonEmpty, "The id of webhook can't be empty")
    s"/webhooks/${webHook.id.getOrElse("")}.json"
  }
}
