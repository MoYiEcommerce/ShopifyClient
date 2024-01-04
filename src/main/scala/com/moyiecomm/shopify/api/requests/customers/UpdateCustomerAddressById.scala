package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Address
import io.circe.Decoder
import io.circe.Encoder

case class UpdateCustomerAddressById(address: Address, override val config: Config)
    extends PutRequest[Address, Address](address, config) {

  override val path: String = {
    require(address.id.nonEmpty, "address id can't be empty")
    require(address.customerId.nonEmpty, "Customer id of the address can't be empty")
    s"customers/${address.customerId.getOrElse("")}/addresses/${address.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[Address]  = Address.addressEncoder
  override val responseDecoder: Decoder[Address] = Address.addressDecoder
}
