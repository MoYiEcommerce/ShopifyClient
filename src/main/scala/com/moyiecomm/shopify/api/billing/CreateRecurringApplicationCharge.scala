package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import RecurringApplicationCharge.{recurringApplicationChargeEncoder, recurringApplicationChargeDecoder}

case class CreateRecurringApplicationCharge(recurringApplicationCharge: RecurringApplicationCharge)(implicit
    val apiConfig: ApiConfig
) extends UpsertItemRequest[RecurringApplicationCharge, RecurringApplicationCharge](recurringApplicationCharge)(
      circeBodySerializer(recurringApplicationChargeEncoder),
      recurringApplicationChargeDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/recurring_application_charges.json"
}
