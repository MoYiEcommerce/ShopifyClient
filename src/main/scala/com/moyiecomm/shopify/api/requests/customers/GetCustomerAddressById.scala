package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Address
import io.circe.Decoder

case class GetCustomerAddressById(customerId: Long, addressId: Long, override val config: Config)
    extends GetRequest[Address](config) {
  override val path: String                      = s"customers/$customerId/addresses/$addressId.json"
  override val responseDecoder: Decoder[Address] = Address.addressDecoder
}
