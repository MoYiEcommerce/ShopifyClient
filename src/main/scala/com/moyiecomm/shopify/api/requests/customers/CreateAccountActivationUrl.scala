package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.AccountActivationUrl
import com.moyiecomm.shopify.api.json.customers.AccountActivationUrl.accountActivationUrlDecoder
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class CreateAccountActivationUrl(customerId: Long, override val config: Config)
    extends PostRequest[Ignored, AccountActivationUrl](EmptyBody, config) {
  override val path: String                                   = s"customers/$customerId/account_activation_url.json"
  override val requestEncoder: Encoder[Ignored]               = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[AccountActivationUrl] = accountActivationUrlDecoder
}
