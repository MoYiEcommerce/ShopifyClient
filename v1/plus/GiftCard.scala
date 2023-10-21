package com.moyiecomm.shopify.api.v1.plus

case class GiftCard(
    apiClientId: Long,
    balance: String,
    code: String,
    createdAt: Long,
    currency: String,
    customerId: Long,
    disabledAt: Long,
    expiresOn: Long,
    id: Long,
    initialValue: String,
    lastCharacters: String,
    lineItemId: Long,
    note: String,
    orderId: Long,
    templateSuffix: String,
    userId: Long,
    updatedAt: Long
)
