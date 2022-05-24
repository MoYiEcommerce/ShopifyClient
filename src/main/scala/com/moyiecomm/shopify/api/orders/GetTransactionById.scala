package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Transaction
import com.moyiecomm.shopify.api.orders.models.Transaction.transactionDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetTransactionById(orderId: Long, transactionId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Transaction]()(transactionDecoder) {
  override def path: String = s"/orders/$orderId/transactions/$transactionId.json"
}
