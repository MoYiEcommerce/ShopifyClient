package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.discounts.models.{DiscountCode, DiscountCodeCreationJob}
import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCode.discountCodeListEncoder
import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateDiscountCodeCreationJob(priceRuleId: Long, discountCodes: List[DiscountCode])(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[List[DiscountCode], DiscountCodeCreationJob](discountCodes)(
      discountCodeListEncoder,
      discountCodeCreationJobDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/price_rules/$priceRuleId/batch.json"
}
