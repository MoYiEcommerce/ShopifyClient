package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest, ShopifyRequest}
import sttp.model.Method
import sttp.client3.circe._
import RecurringApplicationCharge.recurringApplicationChargeDecoder

case class UpdateCappedAmount(recurringChargeId: Int, cappedAmount: Int)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[EmptyBody.type, RecurringApplicationCharge](EmptyBody)(
      circeBodySerializer(ApiRequest.emptyBodyEncoder),
      recurringApplicationChargeDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String =
    s"/recurring_application_charges/$recurringChargeId/customize.json?recurring_application_charge[capped_amount]=$cappedAmount"
}
