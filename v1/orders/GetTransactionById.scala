package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Transaction
import com.moyiecomm.shopify.api.v1.orders.models.Transaction.transactionDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetTransactionById(orderId: Long, transactionId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Transaction]()(transactionDecoder) {
  override def path: String = s"/orders/$orderId/transactions/$transactionId.json"
}
