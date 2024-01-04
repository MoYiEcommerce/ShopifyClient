package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge.applicationChargeDecoder
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge.applicationChargeEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateApplicationCharge(applicationCharge: ApplicationCharge, override val config: Config)
    extends PostRequest[ApplicationCharge, ApplicationCharge](applicationCharge, config) {
  override val path: String = "application_charges.json"

  override val requestEncoder: Encoder[ApplicationCharge]  = applicationChargeEncoder
  override val responseDecoder: Decoder[ApplicationCharge] = applicationChargeDecoder
}
