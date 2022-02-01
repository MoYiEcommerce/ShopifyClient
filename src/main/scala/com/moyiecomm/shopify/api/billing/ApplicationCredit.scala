package com.moyiecomm.shopify.api.billing

case class ApplicationCredit(
    description: String,
    id: Long,
    amount: Int,
    test: Boolean
)
