package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.PriceRule
import com.moyiecomm.shopify.api.discounts.models.PriceRule.{priceRuleDecoder, priceRuleEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreatePriceRule(priceRule: PriceRule)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[PriceRule, PriceRule](priceRule)(priceRuleEncoder, priceRuleDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/price_rules.json"
}
