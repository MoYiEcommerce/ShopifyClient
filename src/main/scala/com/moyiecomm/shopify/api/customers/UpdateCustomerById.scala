package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Customer
import com.moyiecomm.shopify.api.customers.models.Customer.{customerDecoder, customerEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.client3.circe._
import sttp.model.Method

case class UpdateCustomerById(customer: Customer)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Customer, Customer](customer)(circeBodySerializer(customerEncoder), customerDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(customer.id.nonEmpty, "Customer id can't be empty")
    s"/customers/${customer.id.getOrElse("")}.json"
  }
}
