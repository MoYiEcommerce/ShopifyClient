package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.requests.CountRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config

case class GetCountOfCustomCollections(override val config: Config) extends CountRequest(config) {
  override val path: String = "custom_collections/count.json"
}
