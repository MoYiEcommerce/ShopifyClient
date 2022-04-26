package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Customer
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Customer.customerDecoder

case class GetCustomerById(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Customer]()(customerDecoder) {
  override def path: String = s"/customers/$customerId.json"
}
