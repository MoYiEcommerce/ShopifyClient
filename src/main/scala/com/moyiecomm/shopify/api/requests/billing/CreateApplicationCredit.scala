package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit.applicationCreditDecoder
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit.applicationCreditEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateApplicationCredit(applicationCredit: ApplicationCredit, override val config: Config)
    extends PostRequest[ApplicationCredit, ApplicationCredit](applicationCredit, config) {

  override val path: String                                = "application_credits.json"
  override val requestEncoder: Encoder[ApplicationCredit]  = applicationCreditEncoder
  override val responseDecoder: Decoder[ApplicationCredit] = applicationCreditDecoder
}
