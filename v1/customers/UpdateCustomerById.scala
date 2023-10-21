package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Customer
import com.moyiecomm.shopify.api.v1.customers.models.Customer.{customerDecoder, customerEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateCustomerById(customer: Customer)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Customer, Customer](customer)(customerEncoder, customerDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(customer.id.nonEmpty, "Customer id can't be empty")
    s"/customers/${customer.id.getOrElse("")}.json"
  }
}
