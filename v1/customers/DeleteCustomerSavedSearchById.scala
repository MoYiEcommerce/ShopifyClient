package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteCustomerSavedSearchById(customerSavedSearchId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest {
  override def path: String = s"/customer_saved_searches/$customerSavedSearchId.json"
}
