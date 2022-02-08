package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomCollectionList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Collection]] {
  override def path: String = "/custom_collections.json"

}
