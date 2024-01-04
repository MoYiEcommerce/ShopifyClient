package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Address
import com.moyiecomm.shopify.api.json.customers.Address.addressDecoder
import com.moyiecomm.shopify.api.json.customers.Address.addressEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateCustomerAddress(address: Address, override val config: Config)
    extends PostRequest[Address, Address](address, config) {

  override val path: String = {
    require(address.customerId.nonEmpty, "Customer Id of address can't be empty")
    s"customers/${address.customerId.getOrElse("")}/addresses.json"
  }
  override val requestEncoder: Encoder[Address]  = addressEncoder
  override val responseDecoder: Decoder[Address] = addressDecoder
}
