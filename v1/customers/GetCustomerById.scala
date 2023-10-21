package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Customer
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Customer.customerDecoder

case class GetCustomerById(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Customer]()(customerDecoder) {
  override def path: String = s"/customers/$customerId.json"
}
