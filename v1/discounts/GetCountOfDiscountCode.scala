package com.moyiecomm.shopify.api.v1.discounts

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfDiscountCode()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/discount_codes/count.json"
}
