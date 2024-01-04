package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Customer
import io.circe.Decoder

case class SearchCustomerByQuery(query: String, override val config: Config) extends GetRequest[List[Customer]](config) {
  override val path: String                             = s"customers/search.json?query=$query"
  override val responseDecoder: Decoder[List[Customer]] = Customer.customerListDecoder
}
