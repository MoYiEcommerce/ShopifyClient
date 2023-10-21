package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import RecurringApplicationCharge.recurringApplicationChargeListDecoder

case class GetRecurringApplicationChargeList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[RecurringApplicationCharge]]()(recurringApplicationChargeListDecoder) {
  override def path: String = "/recurring_application_charges.json"
}
