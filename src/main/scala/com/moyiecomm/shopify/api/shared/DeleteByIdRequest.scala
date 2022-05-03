package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

abstract class DeleteByIdRequest() extends ApiRequest[Null, Null, Errors](None, None, errorsDecoder) {

  override def method: Method = Method.DELETE

  override def body: Null = null
}
