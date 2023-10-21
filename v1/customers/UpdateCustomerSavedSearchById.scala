package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch
import com.moyiecomm.shopify.api.v1.customers.models.CustomerSavedSearch.{customerSavedSearchDecoder, customerSavedSearchEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateCustomerSavedSearchById(customerSavedSearch: CustomerSavedSearch)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[CustomerSavedSearch, CustomerSavedSearch](customerSavedSearch)(
      customerSavedSearchEncoder,
      customerSavedSearchDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(customerSavedSearch.id.nonEmpty, "The id of customer saved search can't be empty")
    s"/customer_saved_searches/${customerSavedSearch.id.getOrElse("")}.json"
  }
}
