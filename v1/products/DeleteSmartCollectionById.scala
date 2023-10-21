package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteSmartCollectionById(smartCollectionId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/smart_collections/$smartCollectionId.json"
}
