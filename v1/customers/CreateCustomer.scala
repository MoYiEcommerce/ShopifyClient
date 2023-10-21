package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Customer
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import Customer.{customerDecoder, customerEncoder}

case class CreateCustomer(customer: Customer)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Customer, Customer](customer)(customerEncoder, customerDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/customers.json"
}
