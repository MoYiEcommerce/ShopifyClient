package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Transaction
import com.moyiecomm.shopify.api.v1.orders.models.Transaction.transactionListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetTransactionList(orderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Transaction]]()(transactionListDecoder) {
  override def path: String = s"/orders/$orderId/transactions.json"
}
