package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch
import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch.{customerSavedSearchDecoder, customerSavedSearchEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateCustomerSavedSearch(customerSavedSearch: CustomerSavedSearch)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[CustomerSavedSearch, CustomerSavedSearch](customerSavedSearch)(
      customerSavedSearchEncoder,
      customerSavedSearchDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/customer_saved_searches.json"
}
