package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method
import RecurringApplicationCharge.recurringApplicationChargeDecoder
import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder

case class UpdateCappedAmount(recurringChargeId: Int, cappedAmount: Int)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, RecurringApplicationCharge, Errors](
      None,
      Some(recurringApplicationChargeDecoder),
      errorsDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String =
    s"/recurring_application_charges/$recurringChargeId/customize.json?recurring_application_charge[capped_amount]=$cappedAmount"

  override def body: Null = null
}
