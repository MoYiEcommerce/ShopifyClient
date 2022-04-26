package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.CustomerInvite
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import sttp.client3.circe.circeBodySerializer
import sttp.model.Method
import CustomerInvite.customerInviteDecoder

case class SendAccountInvitation(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[EmptyBody.type, CustomerInvite](EmptyBody)(
      circeBodySerializer(ApiRequest.emptyBodyEncoder),
      customerInviteDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/customers/$customerId/send_invite.json"
}
