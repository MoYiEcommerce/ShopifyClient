package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class UpdateOrderingTypeOfProductInSmartCollection(smartCollectionId: Long, productIdList: List[Long])(implicit
    val apiConfig: ApiConfig
) extends ApiRequest[Null, Null](None, None) {
  override def method: Method = Method.PUT

  override def path: String = {
    val queryUri = productIdList.map(id => s"products[]=$id").mkString("&")
    s"/smart_collections/$smartCollectionId/order.json?$queryUri"
  }

  override def body: Null = null
}
