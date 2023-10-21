package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCode.discountCodeListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

// todo handle error field in response
case class GetDiscountCodeListByCreationJobId(priceRuleId: Long, creationJobId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[DiscountCode]]()(discountCodeListDecoder) {
  override def path: String = s"/price_rules/$priceRuleId/batch/$creationJobId/discount_codes.json"
}
