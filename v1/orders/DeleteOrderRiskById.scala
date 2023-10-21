package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteOrderRiskById(orderId: Long, orderRiskId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/orders/$orderId/risks/$orderRiskId.json"
}
