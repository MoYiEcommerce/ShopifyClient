package com.moyiecomm.shopify.api.v1.access

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteStoreFrontAccessTokenById(id: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/storefront_access_tokens/$id.json"
}
