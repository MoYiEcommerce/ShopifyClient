package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.CustomerInvite
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class SendAccountInvitation(customerId: Long, override val config: Config)
    extends PostRequest[Ignored, CustomerInvite](EmptyBody, config) {

  override val path: String                             = s"customers/$customerId/send_invite.json"
  override val requestEncoder: Encoder[Ignored]         = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[CustomerInvite] = CustomerInvite.customerInviteDecoder
}
