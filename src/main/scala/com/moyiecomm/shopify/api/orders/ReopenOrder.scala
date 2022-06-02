package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Order
import com.moyiecomm.shopify.api.orders.models.Order.orderDecoder
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class ReopenOrder(orderId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, Order](None, Some(orderDecoder)) {
  override def body: Null = null

  override def method: Method = Method.POST

  override def path: String = s"/orders/$orderId/open.json"
}
