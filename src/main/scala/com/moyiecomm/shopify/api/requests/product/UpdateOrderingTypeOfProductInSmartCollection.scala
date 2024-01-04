package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe.Decoder
import io.circe.Encoder

case class UpdateOrderingTypeOfProductInSmartCollection(
    smartCollectionId: Long,
    productIdList: List[Long],
    override val config: Config
) extends PutRequest[Ignored, Ignored](EmptyBody, config) {

  override val path: String = {
    val queryUri = productIdList.map(id => s"products[]=$id").mkString("&")
    s"/smart_collections/$smartCollectionId/order.json?$queryUri"
  }
  override val requestEncoder: Encoder[Ignored]  = EmptyBody.emptyBodyEncoder
  override val responseDecoder: Decoder[Ignored] = EmptyBody.emptyBodyDecoder
}
