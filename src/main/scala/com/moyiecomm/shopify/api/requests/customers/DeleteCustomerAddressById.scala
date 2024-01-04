package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeleteCustomerAddressById(customerId: Long, addressId: Long, override val config: Config)
    extends DeleteRequest(config) {
  override val path: String = s"customers/$customerId/addresses/$addressId.json"
}
