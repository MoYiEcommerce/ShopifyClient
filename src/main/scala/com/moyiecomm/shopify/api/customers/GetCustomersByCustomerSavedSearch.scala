package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Customer
import com.moyiecomm.shopify.api.customers.models.Customer.customerListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomersByCustomerSavedSearch(customerSavedSearchId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Customer]]()(customerListDecoder) {
  override def path: String = s"/customer_saved_searches/$customerSavedSearchId/customers.json"
}
