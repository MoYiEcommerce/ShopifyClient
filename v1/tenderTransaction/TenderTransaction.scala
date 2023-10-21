package com.moyiecomm.shopify.api.v1.tenderTransaction

import com.moyiecomm.shopify.api.v1.shared.models.PaymentDetail

case class TenderTransaction(
    id: Long,
    orderId: Long,
    amount: String,
    currency: String,
    userId: Long,
    test: Boolean,
    processedAt: Long,
    remoteReference: String,
    paymentDetails: PaymentDetail,
    paymentMethod: String
)
