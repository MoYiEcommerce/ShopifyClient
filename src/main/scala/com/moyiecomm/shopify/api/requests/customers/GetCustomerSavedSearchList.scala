package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch
import io.circe.Decoder

case class GetCustomerSavedSearchList(override val config: Config) extends GetRequest[List[CustomerSavedSearch]](config) {
  override val path: String                                        = "customer_saved_searches.json"
  override val responseDecoder: Decoder[List[CustomerSavedSearch]] = CustomerSavedSearch.customerSavedSearchListDecoder
}
