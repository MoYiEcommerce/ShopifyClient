package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.ApplicationCredit
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCredit.applicationCreditListDecoder

case class GetApplicationCreditList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[ApplicationCredit]]()(applicationCreditListDecoder) {
  override def path: String = "/application_credits.json"
}
