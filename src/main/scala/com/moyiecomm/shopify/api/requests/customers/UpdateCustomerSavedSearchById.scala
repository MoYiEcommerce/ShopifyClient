package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch
import io.circe.Decoder
import io.circe.Encoder

case class UpdateCustomerSavedSearchById(customerSavedSearch: CustomerSavedSearch, override val config: Config)
    extends PutRequest[CustomerSavedSearch, CustomerSavedSearch](customerSavedSearch, config) {
  override val path: String = {
    require(customerSavedSearch.id.nonEmpty, "The id of customer saved search can't be empty")
    s"customer_saved_searches/${customerSavedSearch.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[CustomerSavedSearch]  = CustomerSavedSearch.customerSavedSearchEncoder
  override val responseDecoder: Decoder[CustomerSavedSearch] = CustomerSavedSearch.customerSavedSearchDecoder
}
