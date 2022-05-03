package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch.customerSavedSearchListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomerSavedSearchList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[CustomerSavedSearch]]()(customerSavedSearchListDecoder) {
  override def path: String = "/customer_saved_searches.json"
}
