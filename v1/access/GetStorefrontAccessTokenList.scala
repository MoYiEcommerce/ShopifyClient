package com.moyiecomm.shopify.api.v1.access

import com.moyiecomm.shopify.api.v1.access.models.StorefrontAccessToken
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import StorefrontAccessToken.storefrontAccessTokenListDecoder

case class GetStorefrontAccessTokenList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[StorefrontAccessToken]]()(storefrontAccessTokenListDecoder) {
  override def path: String = "/storefront_access_tokens.json"
}
