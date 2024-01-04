package com.moyiecomm.shopify.api.requests.discounts

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder

case class GetDiscountCodeLocation(code: String, override val config: Config) extends GetRequest[Ignored](config) {
  override val path: String                      = s"discount_codes/lookup.json?code=$code"
  override val responseDecoder: Decoder[Ignored] = EmptyBody.emptyBodyDecoder
}
