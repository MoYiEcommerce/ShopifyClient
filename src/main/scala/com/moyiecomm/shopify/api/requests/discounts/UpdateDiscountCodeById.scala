package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.discounts.DiscountCode
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeDecoder
import com.moyiecomm.shopify.api.json.discounts.DiscountCode.discountCodeEncoder
import io.circe.Decoder
import io.circe.Encoder

case class UpdateDiscountCodeById(priceRuleId: Long, discountCode: DiscountCode, override val config: Config)
    extends PutRequest[DiscountCode, DiscountCode](discountCode, config) {

  override val path: String = {
    require(discountCode.id.nonEmpty, "The id of discount code can't be empty")
    s"price_rules/$priceRuleId/discount_codes/${discountCode.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[DiscountCode]  = discountCodeEncoder
  override val responseDecoder: Decoder[DiscountCode] = discountCodeDecoder
}
