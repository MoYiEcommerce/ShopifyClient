package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import DiscountCode.{discountCodeDecoder, discountCodeEncoder}
import sttp.model.Method

case class UpdateDiscountCodeById(priceRuleId: Long, discountCode: DiscountCode)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[DiscountCode, DiscountCode](discountCode)(discountCodeEncoder, discountCodeDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(discountCode.id.nonEmpty, "The id of discount code can't be empty")
    s"/price_rules/$priceRuleId/discount_codes/${discountCode.id.getOrElse("")}.json"
  }
}
