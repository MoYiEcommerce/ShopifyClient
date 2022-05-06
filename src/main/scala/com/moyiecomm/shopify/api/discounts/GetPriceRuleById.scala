package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.PriceRule
import com.moyiecomm.shopify.api.discounts.models.PriceRule.priceRuleDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetPriceRuleById(priceRuleId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[PriceRule]()(priceRuleDecoder) {
  override def path: String = s"/price_rules/$priceRuleId.json"
}
