package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Customer
import io.circe.Decoder
import io.circe.Encoder

case class UpdateCustomerById(customer: Customer, override val config: Config)
    extends PutRequest[Customer, Customer](customer, config) {

  override val path: String = {
    require(customer.id.nonEmpty, "Customer id can't be empty")
    s"customers/${customer.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[Customer]  = Customer.customerEncoder
  override val responseDecoder: Decoder[Customer] = Customer.customerDecoder
}
