package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Customer
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.client3.circe._
import sttp.model.Method
import Customer.{customerDecoder, customerEncoder}

case class CreateCustomer(customer: Customer)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Customer, Customer](customer)(circeBodySerializer(customerEncoder), customerDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/customers.json"
}
