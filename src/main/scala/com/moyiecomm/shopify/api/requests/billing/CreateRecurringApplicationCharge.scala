package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge.recurringApplicationChargeDecoder
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge.recurringApplicationChargeEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateRecurringApplicationCharge(recurringApplicationCharge: RecurringApplicationCharge, override val config: Config)
    extends PostRequest[RecurringApplicationCharge, RecurringApplicationCharge](recurringApplicationCharge, config) {

  override val path: String                                         = "recurring_application_charges.json"
  override val requestEncoder: Encoder[RecurringApplicationCharge]  = recurringApplicationChargeEncoder
  override val responseDecoder: Decoder[RecurringApplicationCharge] = recurringApplicationChargeDecoder
}
