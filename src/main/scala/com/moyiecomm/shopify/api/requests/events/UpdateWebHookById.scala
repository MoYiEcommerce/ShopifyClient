package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.WebHook
import io.circe.{Decoder, Encoder}

case class UpdateWebHookById(webHook: WebHook, override val config: Config)
    extends PutRequest[WebHook, WebHook](webHook, config) {

  override val path: String = {
    require(webHook.id.nonEmpty, "The id of webhook can't be empty")
    s"webhooks/${webHook.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[WebHook]  = WebHook.webHookEncoder
  override val responseDecoder: Decoder[WebHook] = WebHook.webHookDecoder
}
