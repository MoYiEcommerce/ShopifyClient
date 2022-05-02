package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.customers.models.Address.addressDecoder
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import com.moyiecomm.shopify.request.ApiRequest.{EmptyBody, emptyBodyEncoder, ignoreResponseDecoder}
import sttp.client3.IgnoreResponse
import sttp.client3.circe.circeBodySerializer
import sttp.model.Method

case class OperateCustomerAddressesByIdList(customerId: Long, addressIds: List[Long], operation: String)(implicit
    val apiConfig: ApiConfig
) extends UpsertItemRequest[EmptyBody.type, IgnoreResponse.type](EmptyBody)(
      circeBodySerializer(emptyBodyEncoder),
      ignoreResponseDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String =
    s"""/customers/$customerId/addresses/set.json?address_ids%5B%5D=${addressIds.mkString(",")}&operation=$operation"""
}
