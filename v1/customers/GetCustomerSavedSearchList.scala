package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch
import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch.customerSavedSearchListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomerSavedSearchList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[CustomerSavedSearch]]()(customerSavedSearchListDecoder) {
  override def path: String = "/customer_saved_searches.json"
}
