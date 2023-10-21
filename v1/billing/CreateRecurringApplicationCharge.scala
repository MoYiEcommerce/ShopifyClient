package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import RecurringApplicationCharge.{recurringApplicationChargeEncoder, recurringApplicationChargeDecoder}

case class CreateRecurringApplicationCharge(recurringApplicationCharge: RecurringApplicationCharge)(implicit
    val apiConfig: ApiConfig
) extends UpsertItemRequest[RecurringApplicationCharge, RecurringApplicationCharge](recurringApplicationCharge)(
      recurringApplicationChargeEncoder,
      recurringApplicationChargeDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/recurring_application_charges.json"
}
