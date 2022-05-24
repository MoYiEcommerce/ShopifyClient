package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Transaction
import com.moyiecomm.shopify.api.orders.models.Transaction.{transactionDecoder, transactionEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateTransaction(transaction: Transaction)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Transaction, Transaction](transaction)(transactionEncoder, transactionDecoder) {
  override def method: Method = Method.POST

  override def path: String = {
    require(transaction.orderId.nonEmpty, "Order id of transaction can't be empty")
    s"/orders/${transaction.orderId.getOrElse("")}/transactions.json"
  }
}
