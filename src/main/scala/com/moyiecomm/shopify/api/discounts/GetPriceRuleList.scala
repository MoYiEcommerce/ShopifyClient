package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.PriceRule
import com.moyiecomm.shopify.api.discounts.models.PriceRule.priceRuleListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetPriceRuleList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[PriceRule]]()(priceRuleListDecoder) {
  override def path: String = "/price_rules.json"
}
