package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfWebHooks(override val config: Config) extends CountRequest(config) {
  override val path: String = "webhooks/count.json"
}
