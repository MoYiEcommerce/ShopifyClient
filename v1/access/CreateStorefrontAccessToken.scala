package com.moyiecomm.shopify.api.v1.access

import com.moyiecomm.shopify.api.v1.access.models.StorefrontAccessToken
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import StorefrontAccessToken.{storefrontAccessTokenEncoder, storefrontAccessTokenDecoder}

case class CreateStorefrontAccessToken(storefrontAccessToken: StorefrontAccessToken)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[StorefrontAccessToken, StorefrontAccessToken](storefrontAccessToken)(
      storefrontAccessTokenEncoder,
      storefrontAccessTokenDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/storefront_access_tokens.json"
}
