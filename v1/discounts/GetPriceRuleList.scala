package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule
import com.moyiecomm.shopify.api.v1.discounts.models.PriceRule.priceRuleListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetPriceRuleList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[PriceRule]]()(priceRuleListDecoder) {
  override def path: String = "/price_rules.json"
}
