package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest, ShopifyRequest}
import sttp.model.Method
import sttp.client3._
import io.circe.generic.auto._
import sttp.client3.circe._

class UpdateOrderingTypeOfProductInSmartCollection(smartCollectionId: Long, productIdList: List[Long])(implicit
    val apiConfig: ApiConfig
) extends ShopifyRequest[EmptyBody.type, IgnoreResponse.type] {
  override def method: Method = Method.PUT

  override def path: String = {
    val queryUri = productIdList.map(id => s"products[]=$id").mkString("&")
    s"/smart_collections/$smartCollectionId/order.json?$queryUri"
  }

  override def body: ApiRequest.RequestEntity = EmptyBody
}
