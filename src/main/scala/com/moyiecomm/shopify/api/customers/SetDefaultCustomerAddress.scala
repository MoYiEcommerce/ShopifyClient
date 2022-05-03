package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.customers.models.Address.addressDecoder
import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method
case class SetDefaultCustomerAddress(customerId: Long, addressId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, Address, Errors](None, Some(addressDecoder), errorsDecoder) {
  override def method: Method = Method.PUT

  override def path: String = s"/customers/$customerId/addresses/$addressId/default.json"

  override def body: Null = null
}
