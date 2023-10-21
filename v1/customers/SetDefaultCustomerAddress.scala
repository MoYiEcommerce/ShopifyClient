package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.customers.models.Address
import com.moyiecomm.shopify.api.v1.customers.models.Address.addressDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class SetDefaultCustomerAddress(customerId: Long, addressId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, Address](None, Some(addressDecoder)) {
  override def method: Method = Method.PUT

  override def path: String = s"/customers/$customerId/addresses/$addressId/default.json"

  override def body: Null = null
}
