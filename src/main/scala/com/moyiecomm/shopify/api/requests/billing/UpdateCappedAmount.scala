package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge.recurringApplicationChargeDecoder
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class UpdateCappedAmount(recurringChargeId: Int, cappedAmount: Int, override val config: Config)
    extends PutRequest[Ignored, RecurringApplicationCharge](EmptyBody, config) {

  override val path: String =
    s"recurring_application_charges/$recurringChargeId/customize.json?recurring_application_charge[capped_amount]=$cappedAmount"
  override val requestEncoder: Encoder[Ignored]                     = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[RecurringApplicationCharge] = recurringApplicationChargeDecoder
}
