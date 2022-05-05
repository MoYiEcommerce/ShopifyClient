package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.discounts.models.DiscountCode.{discountCodeDecoder, discountCodeEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateDiscountCode(priceRuleId: Long, discountCodes: DiscountCode)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[DiscountCode, DiscountCode](discountCodes)(
      discountCodeEncoder,
      discountCodeDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/price_rules/$priceRuleId/discount_codes.json"
}
