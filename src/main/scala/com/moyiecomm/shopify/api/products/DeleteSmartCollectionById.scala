package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteSmartCollectionById(smartCollectionId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/smart_collections/$smartCollectionId.json"
}
