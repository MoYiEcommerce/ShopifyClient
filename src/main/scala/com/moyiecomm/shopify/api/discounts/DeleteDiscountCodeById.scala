package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteDiscountCodeById(priceRuleId: Long, discountCodeId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest() {
  override def path: String = s"/price_rules/$priceRuleId/discount_codes/$discountCodeId.json"
}
