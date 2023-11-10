package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfProducts(override val config: Config) extends CountRequest(config) {
  override val path: String = "/products/count.json"
}
