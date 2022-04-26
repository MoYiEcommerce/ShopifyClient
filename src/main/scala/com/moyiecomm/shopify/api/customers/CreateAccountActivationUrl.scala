package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.AccountActivationUrl
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import sttp.client3.circe._
import AccountActivationUrl.accountActivationUrlDecoder
import sttp.model.Method

case class CreateAccountActivationUrl(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[EmptyBody.type, AccountActivationUrl](EmptyBody)(
      circeBodySerializer(ApiRequest.emptyBodyEncoder),
      accountActivationUrlDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/customers/$customerId/account_activation_url.json"
}
