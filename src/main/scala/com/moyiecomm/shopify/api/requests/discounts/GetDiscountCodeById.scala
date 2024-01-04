package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeDecoder
import io.circe.Decoder

case class GetDiscountCodeById(priceRuleId: Long, discountCodeId: Long, override val config: Config)
    extends GetRequest[DiscountCode](config) {
  override val path: String                           = s"price_rules/$priceRuleId/discount_codes/$discountCodeId.json"
  override val responseDecoder: Decoder[DiscountCode] = discountCodeDecoder
}
