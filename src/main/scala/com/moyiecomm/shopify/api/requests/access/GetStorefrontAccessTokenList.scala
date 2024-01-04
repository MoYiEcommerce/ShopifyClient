package com.moyiecomm.shopify.api.requests.access

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.access.StorefrontAccessToken
import com.moyiecomm.shopify.api.json.access.StorefrontAccessToken.storefrontAccessTokenListDecoder
import io.circe.Decoder

case class GetStorefrontAccessTokenList(override val config: Config) extends GetRequest[List[StorefrontAccessToken]](config) {

  override val path: String                                          = "/storefront_access_tokens.json"
  override val responseDecoder: Decoder[List[StorefrontAccessToken]] = storefrontAccessTokenListDecoder
}
