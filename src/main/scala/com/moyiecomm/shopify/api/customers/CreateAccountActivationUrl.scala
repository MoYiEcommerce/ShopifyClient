package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.AccountActivationUrl
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import AccountActivationUrl.accountActivationUrlDecoder
import sttp.model.Method

case class CreateAccountActivationUrl(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, AccountActivationUrl](
      None,
      Some(accountActivationUrlDecoder)
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/customers/$customerId/account_activation_url.json"

  override def body: Null = null
}
