package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetRecurringApplicationChargeList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[RecurringApplicationCharge]] {
  override def path: String = "/recurring_application_charges.json"
}
