package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.access.models.StorefrontAccessToken
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.client3.circe._
import sttp.model.Method
import StorefrontAccessToken.{storefrontAccessTokenEncoder, storefrontAccessTokenDecoder}

case class CreateStorefrontAccessToken(storefrontAccessToken: StorefrontAccessToken)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[StorefrontAccessToken, StorefrontAccessToken](storefrontAccessToken)(
      circeBodySerializer(storefrontAccessTokenEncoder),
      storefrontAccessTokenDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/storefront_access_tokens.json"
}
