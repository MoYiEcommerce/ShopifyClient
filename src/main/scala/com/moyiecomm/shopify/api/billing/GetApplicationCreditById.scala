package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCredit.applicationCreditDecoder

case class GetApplicationCreditById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ApplicationCredit]()(applicationCreditDecoder) {
  override def path: String = s"/application_credits/$id.json"
}
