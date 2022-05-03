package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteCustomerSavedSearchById(customerSavedSearchId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest {
  override def path: String = s"/customer_saved_searches/$customerSavedSearchId.json"
}
