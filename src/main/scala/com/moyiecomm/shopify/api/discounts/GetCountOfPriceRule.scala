package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfPriceRule()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/price_rules/count.json"
}
