package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.PriceRule
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleDecoder
import io.circe.Decoder

private case class GetPriceRuleById(priceRuleId: Long, override val config: Config) extends GetRequest[PriceRule](config) {
  override val path: String                        = s"price_rules/$priceRuleId.json"
  override val responseDecoder: Decoder[PriceRule] = priceRuleDecoder
}
