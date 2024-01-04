package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Address
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class SetDefaultCustomerAddress(customerId: Long, addressId: Long, override val config: Config)
    extends PutRequest[Ignored, Address](EmptyBody, config) {
  override val path: String                      = s"customers/$customerId/addresses/$addressId/default.json"
  override val requestEncoder: Encoder[Ignored]  = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[Address] = Address.addressDecoder
}
