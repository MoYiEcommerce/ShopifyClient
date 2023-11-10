package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfCustomCollections(override val config: Config) extends CountRequest(config) {
  override val path: String = "custom_collections/count.json"
}
