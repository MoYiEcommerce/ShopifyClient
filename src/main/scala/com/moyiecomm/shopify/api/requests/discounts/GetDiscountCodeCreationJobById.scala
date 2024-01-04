package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCodeCreationJob
import com.moyiecomm.shopify.api.json.discounts.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import io.circe.Decoder

case class GetDiscountCodeCreationJobById(priceRuleId: Long, discountCodesCreationJobId: Long, override val config: Config)
    extends GetRequest[DiscountCodeCreationJob](config) {

  override val path: String = s"price_rules/$priceRuleId/batch/$discountCodesCreationJobId.json"
  override val responseDecoder: Decoder[DiscountCodeCreationJob] = discountCodeCreationJobDecoder
}
