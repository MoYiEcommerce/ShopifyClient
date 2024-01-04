package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch.customerSavedSearchDecoder
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch.customerSavedSearchEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateCustomerSavedSearch(customerSavedSearch: CustomerSavedSearch, override val config: Config)
    extends PostRequest[CustomerSavedSearch, CustomerSavedSearch](customerSavedSearch, config) {

  override val path: String                                  = "customer_saved_searches.json"
  override val requestEncoder: Encoder[CustomerSavedSearch]  = customerSavedSearchEncoder
  override val responseDecoder: Decoder[CustomerSavedSearch] = customerSavedSearchDecoder
}
