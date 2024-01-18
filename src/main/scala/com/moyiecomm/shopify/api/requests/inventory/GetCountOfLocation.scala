package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfLocation(override val config: Config) extends CountRequest(config) {
  override val path: String = "locations/count.json"
}
