package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteOrderRiskById(orderId: Long, orderRiskId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/orders/$orderId/risks/$orderRiskId.json"
}
