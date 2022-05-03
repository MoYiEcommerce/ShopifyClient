package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch.customerSavedSearchDecoder

case class GetCustomerSavedSearchById(customerSavedSearchId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[CustomerSavedSearch]()(customerSavedSearchDecoder) {
  override def path: String = s"/customer_saved_searches/$customerSavedSearchId.json"
}
