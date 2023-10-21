package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
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
