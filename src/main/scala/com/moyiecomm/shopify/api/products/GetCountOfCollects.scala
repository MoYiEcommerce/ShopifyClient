package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfCollects()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/collects/count.json"
}
