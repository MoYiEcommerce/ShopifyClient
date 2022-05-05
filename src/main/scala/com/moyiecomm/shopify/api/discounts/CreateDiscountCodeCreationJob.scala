package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.discounts.models.{DiscountCode, DiscountCodeCreationJob}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode.discountCodeListEncoder
import com.moyiecomm.shopify.api.discounts.models.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
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
