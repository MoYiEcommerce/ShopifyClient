package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.requests.CountRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config

case class GetCountOfProducts(override val config: Config) extends CountRequest(config) {
  override val path: String = "/products/count.json"
}
