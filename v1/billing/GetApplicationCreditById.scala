package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCredit.applicationCreditDecoder

case class GetApplicationCreditById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ApplicationCredit]()(applicationCreditDecoder) {
  override def path: String = s"/application_credits/$id.json"
}
