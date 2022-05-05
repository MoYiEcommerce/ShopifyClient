package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.discounts.models.DiscountCode.discountCodeDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetDiscountCodeById(priceRuleId: Long, discountCodeId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[DiscountCode]()(discountCodeDecoder) {
  override def path: String = s"/price_rules/$priceRuleId/discount_codes/$discountCodeId.json"
}
