package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.PriceRule
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleListDecoder
import io.circe.Decoder

case class GetPriceRuleList(override val config: Config) extends GetRequest[List[PriceRule]](config) {
  override val path: String                              = "price_rules.json"
  override val responseDecoder: Decoder[List[PriceRule]] = priceRuleListDecoder
}
