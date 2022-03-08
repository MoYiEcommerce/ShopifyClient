package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfSmartCollections()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/smart_collections/count.json"
}
