package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import ApplicationCredit._

case class CreateApplicationCredit()(applicationCredit: ApplicationCredit)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ApplicationCredit, ApplicationCredit](applicationCredit) {
  override def method: Method = Method.POST

  override def path: String = "/application_credits.json"
}
