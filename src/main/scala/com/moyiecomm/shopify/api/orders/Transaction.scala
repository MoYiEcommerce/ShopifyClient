package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.Transaction._

case class Transaction(
    amount: String,
    authorization: String,
    authorizationExpiresAt: Long,
    createdAt: Long,
    currency: String,
    deviceId: Int,
    errorCode: String,
    extendedAuthorizationAttributes: ExtendedAuthorizationAttribute,
    gateway: String,
    id: Long,
    kind: String,
    locationId: Long,
    message: String,
    orderId: Long,
    paymentDetails: PaymentDetail,
    parentId: Long,
    paymentsRefundAttributes: PaymentRefundAttribute,
    processedAt: Long,
    receipt: Receipt,
    sourceName: String,
    status: String,
    test: Boolean,
    userId: Long,
    currencyExchangeAdjustment: CurrencyExchangeAdjustment
)

object Transaction {
  case class ExtendedAuthorizationAttribute()
  case class PaymentRefundAttribute()
  case class CurrencyExchangeAdjustment()
}
