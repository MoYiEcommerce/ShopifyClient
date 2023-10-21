package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import RecurringApplicationCharge.recurringApplicationChargeDecoder

case class GetRecurringApplicationChargeById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[RecurringApplicationCharge]()(recurringApplicationChargeDecoder) {
  override def path: String = s"/recurring_application_charges/$id.json"
}
