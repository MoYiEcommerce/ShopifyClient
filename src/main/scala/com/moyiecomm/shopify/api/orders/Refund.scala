package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.Refund._

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
