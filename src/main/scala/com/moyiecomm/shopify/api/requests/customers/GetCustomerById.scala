package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Customer
import io.circe.Decoder

case class GetCustomerById(customerId: Long, override val config: Config) extends GetRequest[Customer](config) {
  override val path: String                       = s"customers/$customerId.json"
  override val responseDecoder: Decoder[Customer] = Customer.customerDecoder
}
