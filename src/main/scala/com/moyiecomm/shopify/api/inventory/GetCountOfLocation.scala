package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfLocation()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/locations/count.json"
}
