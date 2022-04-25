package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCredit.applicationCreditListDecoder

case class GetApplicationCreditList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[ApplicationCredit]]()(applicationCreditListDecoder) {
  override def path: String = "/application_credits.json"
}
