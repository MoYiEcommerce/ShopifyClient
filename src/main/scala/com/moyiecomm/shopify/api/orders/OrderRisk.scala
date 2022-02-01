package com.moyiecomm.shopify.api.orders

case class OrderRisk(
    causeCancel: Boolean,
    checkoutId: Long,
    display: Boolean,
    id: Long,
    message: String,
    orderId: Long,
    recommendation: String,
    score: Int,
    source: String
)
