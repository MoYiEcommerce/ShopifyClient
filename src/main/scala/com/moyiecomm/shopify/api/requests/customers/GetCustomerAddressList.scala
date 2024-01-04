package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.customers.Address
import io.circe.Decoder

case class GetCustomerAddressList(customerId: Long, override val config: Config) extends GetRequest[List[Address]](config) {
  override val path: String                            = s"customers/$customerId/addresses.json"
  override val responseDecoder: Decoder[List[Address]] = Address.addressListDecoder
}
