package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.PriceRule
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleDecoder
import com.moyiecomm.shopify.api.json.discounts.PriceRule.priceRuleEncoder
import io.circe.Decoder
import io.circe.Encoder

case class UpdatePriceRuleById(priceRule: PriceRule, override val config: Config)
    extends PutRequest[PriceRule, PriceRule](priceRule, config) {

  override val path: String = {
    require(priceRule.id.nonEmpty, "The id of price rule can't be empty")
    s"price_rules/${priceRule.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[PriceRule]  = priceRuleEncoder
  override val responseDecoder: Decoder[PriceRule] = priceRuleDecoder
}
