package com.moyiecomm.shopify.api.requests.access

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.access.StorefrontAccessToken
import com.moyiecomm.shopify.api.json.access.StorefrontAccessToken.storefrontAccessTokenDecoder
import com.moyiecomm.shopify.api.json.access.StorefrontAccessToken.storefrontAccessTokenEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateStorefrontAccessToken(storefrontAccessToken: StorefrontAccessToken, override val config: Config)
    extends PostRequest[StorefrontAccessToken, StorefrontAccessToken](storefrontAccessToken, config) {
  override val path: String                                    = "storefront_access_tokens.json"
  override val requestEncoder: Encoder[StorefrontAccessToken]  = storefrontAccessTokenEncoder
  override val responseDecoder: Decoder[StorefrontAccessToken] = storefrontAccessTokenDecoder
}
