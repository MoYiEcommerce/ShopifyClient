package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeListEncoder
import com.moyiecomm.shopify.api.json.discounts.DiscountCodeCreationJob
import com.moyiecomm.shopify.api.json.discounts.DiscountCodeCreationJob.discountCodeCreationJobDecoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateDiscountCodeCreationJob(priceRuleId: Long, discountCodes: List[DiscountCode], override val config: Config)
    extends PostRequest[List[DiscountCode], DiscountCodeCreationJob](discountCodes, config) {

  override val path: String                                      = s"price_rules/$priceRuleId/batch.json"
  override val requestEncoder: Encoder[List[DiscountCode]]       = discountCodeListEncoder
  override val responseDecoder: Decoder[DiscountCodeCreationJob] = discountCodeCreationJobDecoder
}
