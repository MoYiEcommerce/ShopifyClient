package com.moyiecomm.shopify.api.billing

case class UsageCharge(
    createAt: Long,
    description: String,
    id: Long,
    price: String,
    recurringApplicationChargeId: Long,
    updateAt: Long
)
