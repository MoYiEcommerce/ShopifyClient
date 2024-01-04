package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.CustomerSavedSearch
import io.circe.Decoder

case class GetCustomerSavedSearchById(customerSavedSearchId: Long, override val config: Config)
    extends GetRequest[CustomerSavedSearch](config) {
  override val path: String                                  = s"customer_saved_searches/$customerSavedSearchId.json"
  override val responseDecoder: Decoder[CustomerSavedSearch] = CustomerSavedSearch.customerSavedSearchDecoder
}
