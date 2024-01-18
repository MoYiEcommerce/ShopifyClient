package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.WebHook
import com.moyiecomm.shopify.api.json.events.WebHook.{webHookDecoder, webHookEncoder}
import io.circe.{Decoder, Encoder}

case class CreateWebHook(webHook: WebHook, override val config: Config) extends PostRequest[WebHook, WebHook](webHook, config) {

  override val path: String                      = "webhooks.json"
  override val requestEncoder: Encoder[WebHook]  = webHookEncoder
  override val responseDecoder: Decoder[WebHook] = webHookDecoder
}
