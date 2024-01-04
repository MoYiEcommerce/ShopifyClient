package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeletePriceRuleById(priceRuleId: Long, override val config: Config) extends DeleteRequest(config) {
  override val path: String = s"price_rules/$priceRuleId.json"
}
