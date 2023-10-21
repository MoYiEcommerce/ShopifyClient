package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Customer
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Customer.customerListDecoder

case class GetCustomerList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Customer]]()(customerListDecoder) {
  override def path: String = "/customers.json"
}
