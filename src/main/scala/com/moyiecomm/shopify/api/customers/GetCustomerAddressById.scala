package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Address.addressDecoder

case class GetCustomerAddressById(customerId: Long, addressId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Address]()(addressDecoder) {
  override def path: String = s"/customers/$customerId/addresses/$addressId.json"
}
