package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Customer
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Customer.customerListDecoder

case class SearchCustomerByQuery(query: String)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Customer]]()(customerListDecoder) {
  override def path: String = s"/customers/search.json?query=$query"
}
