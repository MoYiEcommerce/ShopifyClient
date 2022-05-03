package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.CustomerInvite
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method
import CustomerInvite.customerInviteDecoder
import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder

case class SendAccountInvitation(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, CustomerInvite, Errors](
      None,
      Some(customerInviteDecoder),
      errorsDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/customers/$customerId/send_invite.json"

  override def body: Null = null
}
