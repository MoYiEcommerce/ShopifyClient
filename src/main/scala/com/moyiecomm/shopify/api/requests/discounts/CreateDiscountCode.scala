package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeDecoder
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateDiscountCode(priceRuleId: Long, discountCodes: DiscountCode, override val config: Config)
    extends PostRequest[DiscountCode, DiscountCode](discountCodes, config) {

  override val path: String                           = s"price_rules/$priceRuleId/discount_codes.json"
  override val requestEncoder: Encoder[DiscountCode]  = discountCodeEncoder
  override val responseDecoder: Decoder[DiscountCode] = discountCodeDecoder
}
