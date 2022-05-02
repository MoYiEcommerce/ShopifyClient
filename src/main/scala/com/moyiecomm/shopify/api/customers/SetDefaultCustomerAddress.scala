package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.customers.models.Address.addressDecoder
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import com.moyiecomm.shopify.request.ApiRequest.{EmptyBody, emptyBodyEncoder}
import sttp.model.Method
import sttp.client3.circe._

case class SetDefaultCustomerAddress(customerId: Long, addressId: Long)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[EmptyBody.type, Address](EmptyBody)(circeBodySerializer(emptyBodyEncoder), addressDecoder) {
  override def method: Method = Method.PUT

  override def path: String = s"/customers/$customerId/addresses/$addressId/default.json"
}
