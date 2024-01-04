package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeListDecoder
import io.circe.Decoder

// todo handle error field in response
case class GetDiscountCodeListByCreationJobId(priceRuleId: Long, creationJobId: Long, override val config: Config)
    extends GetRequest[List[DiscountCode]](config) {
  override val path: String                                 = s"price_rules/$priceRuleId/batch/$creationJobId/discount_codes.json"
  override val responseDecoder: Decoder[List[DiscountCode]] = discountCodeListDecoder
}
