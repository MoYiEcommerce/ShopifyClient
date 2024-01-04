package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfPriceRule(override val config: Config) extends CountRequest(config) {
  override val path: String = "price_rules/count.json"
}
