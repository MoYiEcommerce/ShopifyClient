package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule
import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule.{priceRuleDecoder, priceRuleEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdatePriceRuleById(priceRule: PriceRule)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[PriceRule, PriceRule](priceRule)(priceRuleEncoder, priceRuleDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(priceRule.id.nonEmpty, "The id of price rule can't be empty")
    s"/price_rules/${priceRule.id.getOrElse("")}.json"
  }
}
