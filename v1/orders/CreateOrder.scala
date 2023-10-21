package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Order
import com.moyiecomm.shopify.api.v1.orders.models.Order.{orderDecoder, orderEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateOrder(order: Order)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Order, Order](order)(orderEncoder, orderDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/orders.json"
}
