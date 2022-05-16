package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.orders.models.Refund._
import com.moyiecomm.shopify.api.shared.models.LineItem

case class Refund(
    createAt: Long,
    duties: List[Duty],
    id: Long,
    note: String,
    orderAdjustments: List[OrderAdjustment],
    processedAt: Long,
    refundDuties: List[RefundDuty],
    refundLineItems: List[LineItem],
    transactions: List[Transaction],
    userId: Long
)

object Refund {
  case class Duty()
  case class OrderAdjustment()
  case class RefundDuty()
}
