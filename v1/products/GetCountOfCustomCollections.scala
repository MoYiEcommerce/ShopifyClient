package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfCustomCollections()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/custom_collections/count.json"
}
