package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Address.addressListDecoder

case class GetCustomerAddressList(customerId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Address]]()(addressListDecoder) {
  override def path: String = s"/customers/$customerId/addresses.json"
}
