package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

class DeleteStoreFrontAccessTokenById(id: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/storefront_access_tokens/$id.json"
}
