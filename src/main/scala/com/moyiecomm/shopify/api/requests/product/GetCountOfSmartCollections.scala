package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.requests.CountRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config

case class GetCountOfSmartCollections(override val config: Config) extends CountRequest(config) {
  override val path: String = "/smart_collections/count.json"
}
