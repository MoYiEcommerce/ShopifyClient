package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import DiscountCode.discountCodeListDecoder

case class GetDiscountCodeList(priceRuleId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[DiscountCode]]()(discountCodeListDecoder) {
  override def path: String = s"/price_rules/$priceRuleId/discount_codes.json"
}
