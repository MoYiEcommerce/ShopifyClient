package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import ApplicationCredit.{applicationCreditEncoder, applicationCreditDecoder}

case class CreateApplicationCredit(applicationCredit: ApplicationCredit)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ApplicationCredit, ApplicationCredit](applicationCredit)(
      applicationCreditEncoder,
      applicationCreditDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/application_credits.json"
}
