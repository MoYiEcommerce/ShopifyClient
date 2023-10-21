package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.ApiResponse.Ignored
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import com.moyiecomm.shopify.api.requests.PutRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

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
