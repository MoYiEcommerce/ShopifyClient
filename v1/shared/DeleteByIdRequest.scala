package com.moyiecomm.shopify.api.v1.shared

import com.moyiecomm.shopify.request.ApiRequest
import sttp.model.Method

abstract class DeleteByIdRequest() extends ApiRequest[Null, Null](None, None) {

  override def method: Method = Method.DELETE

  override def body: Null = null
}
