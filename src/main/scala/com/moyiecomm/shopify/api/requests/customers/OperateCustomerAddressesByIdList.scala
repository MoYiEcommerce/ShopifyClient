package com.moyiecomm.shopify.api.requests.customers

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class OperateCustomerAddressesByIdList(
    customerId: Long,
    addressIds: List[Long],
    operation: String,
    override val config: Config
) extends PutRequest[Ignored, Ignored](EmptyBody, config) {
  override val path: String =
    s"""customers/$customerId/addresses/set.json?address_ids%5B%5D=${addressIds.mkString(",")}&operation=$operation"""
  override val requestEncoder: Encoder[Ignored]  = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[Ignored] = EmptyBody.emptyBodyDecoder
}
