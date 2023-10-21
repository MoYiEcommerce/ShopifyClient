package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import com.moyiecomm.shopify.api.v1.discounts.models.{DiscountCode, DiscountCodeCreationJob}
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class GetDiscountCodeCreationJobById(priceRuleId: Long, discountCodesCreationJobId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[DiscountCodeCreationJob]()(discountCodeCreationJobDecoder) {
  override def method: Method = Method.GET

  override def path: String = s"/price_rules/$priceRuleId/batch/$discountCodesCreationJobId.json"
}
