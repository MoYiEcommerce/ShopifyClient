package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Customer
import com.moyiecomm.shopify.api.v1.customers.models.Customer.customerListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomersByCustomerSavedSearch(customerSavedSearchId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Customer]]()(customerListDecoder) {
  override def path: String = s"/customer_saved_searches/$customerSavedSearchId/customers.json"
}
