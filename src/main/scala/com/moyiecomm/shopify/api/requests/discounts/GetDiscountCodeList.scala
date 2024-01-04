package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeListDecoder
import io.circe.Decoder

case class GetDiscountCodeList(priceRuleId: Long, override val config: Config) extends GetRequest[List[DiscountCode]](config) {
  override val path: String                                 = s"price_rules/$priceRuleId/discount_codes.json"
  override val responseDecoder: Decoder[List[DiscountCode]] = discountCodeListDecoder
}
