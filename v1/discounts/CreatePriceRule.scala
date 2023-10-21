package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule
import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule.{priceRuleDecoder, priceRuleEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreatePriceRule(priceRule: PriceRule)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[PriceRule, PriceRule](priceRule)(priceRuleEncoder, priceRuleDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/price_rules.json"
}
