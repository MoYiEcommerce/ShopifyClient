package com.moyiecomm.shopify.api.events

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteWebHookById(webHookId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/webhooks/$webHookId.json"
}
