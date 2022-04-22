package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.access.models.StorefrontAccessToken
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import StorefrontAccessToken.storefrontAccessTokenListDecoder

case class GetStorefrontAccessTokenList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[StorefrontAccessToken]]()(storefrontAccessTokenListDecoder) {
  override def path: String = "/storefront_access_tokens.json"
}
