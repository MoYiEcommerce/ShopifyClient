package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class CancelRecurringApplicationChargeById(id: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/recurring_application_charges/$id.json"
}
