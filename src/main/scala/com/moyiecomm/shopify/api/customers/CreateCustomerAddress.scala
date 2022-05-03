package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import Address.{addressEncoder, addressDecoder}

case class CreateCustomerAddress(address: Address)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Address, Address](address)(addressEncoder, addressDecoder) {
  override def method: Method = Method.POST

  override def path: String = {
    require(address.customerId.nonEmpty, "Customer Id of address can't be empty")
    s"/customers/${address.customerId.getOrElse("")}/addresses.json"
  }
}
