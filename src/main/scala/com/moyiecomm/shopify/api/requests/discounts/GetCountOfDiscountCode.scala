package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfDiscountCode(override val config: Config) extends CountRequest(config) {
  override val path: String = "discount_codes/count.json"
}
