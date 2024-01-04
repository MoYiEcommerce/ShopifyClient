package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Customer
import com.moyiecomm.shopify.api.json.customers.Customer.customerDecoder
import com.moyiecomm.shopify.api.json.customers.Customer.customerEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateCustomer(customer: Customer, override val config: Config)
    extends PostRequest[Customer, Customer](customer, config) {

  override val path: String                       = "customers.json"
  override val requestEncoder: Encoder[Customer]  = customerEncoder
  override val responseDecoder: Decoder[Customer] = customerDecoder
}
