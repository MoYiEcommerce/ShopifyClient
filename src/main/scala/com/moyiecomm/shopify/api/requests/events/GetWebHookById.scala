package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.WebHook
import io.circe.Decoder

case class GetWebHookById(webhookId: Long, override val config: Config) extends GetRequest[WebHook](config) {
  override val path: String                      = s"webhooks/$webhookId.json"
  override val responseDecoder: Decoder[WebHook] = WebHook.webHookDecoder
}
