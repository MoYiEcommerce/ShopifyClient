package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import DiscountCode.discountCodeListDecoder

case class GetDiscountCodeList(priceRuleId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[DiscountCode]]()(discountCodeListDecoder) {
  override def path: String = s"/price_rules/$priceRuleId/discount_codes.json"
}
