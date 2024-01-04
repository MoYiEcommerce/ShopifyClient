package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.PriceRule
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleDecoder
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreatePriceRule(priceRule: PriceRule, override val config: Config)
    extends PostRequest[PriceRule, PriceRule](priceRule, config) {

  override val path: String                        = "price_rules.json"
  override val requestEncoder: Encoder[PriceRule]  = priceRuleEncoder
  override val responseDecoder: Decoder[PriceRule] = priceRuleDecoder
}
