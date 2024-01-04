package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfCustomerSearch(override val config: Config) extends CountRequest(config) {
  override val path: String = s"customer_saved_searches/count.json"
}
