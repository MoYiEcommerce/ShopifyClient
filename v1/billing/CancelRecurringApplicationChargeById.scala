package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class CancelRecurringApplicationChargeById(id: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/recurring_application_charges/$id.json"
}
