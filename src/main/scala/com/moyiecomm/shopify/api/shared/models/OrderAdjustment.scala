package com.moyiecomm.shopify.api.shared.models

case class OrderAdjustment(
    id: Long,
    orderId: Long,
    refundId: Long,
    amount: Double,
    taxAmount: Double,
    kind: String,
    reason: String,
    amountSet: AmountSet,
    taxAmountSet: AmountSet
)
