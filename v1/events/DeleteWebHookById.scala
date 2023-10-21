package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteWebHookById(webHookId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/webhooks/$webHookId.json"
}
