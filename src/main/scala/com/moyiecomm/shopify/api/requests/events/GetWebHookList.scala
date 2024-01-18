package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.events.WebHook
import io.circe.Decoder

case class GetWebHookList(override val config: Config) extends GetRequest[List[WebHook]](config) {
  override val path: String                            = "webhooks.json"
  override val responseDecoder: Decoder[List[WebHook]] = WebHook.webHookListDecoder
}
