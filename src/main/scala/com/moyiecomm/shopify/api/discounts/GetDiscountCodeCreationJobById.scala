package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import com.moyiecomm.shopify.api.discounts.models.{DiscountCode, DiscountCodeCreationJob}
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class GetDiscountCodeCreationJobById(priceRuleId: Long, discountCodesCreationJobId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[DiscountCodeCreationJob]()(discountCodeCreationJobDecoder) {
  override def method: Method = Method.GET

  override def path: String = s"/price_rules/$priceRuleId/batch/$discountCodesCreationJobId.json"
}
