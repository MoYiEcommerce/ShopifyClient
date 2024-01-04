package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Customer
import io.circe.Decoder

case class GetCustomerList(override val config: Config) extends GetRequest[List[Customer]](config) {
  override val path: String                             = "customers.json"
  override val responseDecoder: Decoder[List[Customer]] = Customer.customerListDecoder
}
