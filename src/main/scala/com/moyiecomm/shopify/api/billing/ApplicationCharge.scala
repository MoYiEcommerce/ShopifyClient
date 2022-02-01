package com.moyiecomm.shopify.api.billing

case class ApplicationCharge(
    confirmationUrl: String,
    createAt: Long,
    id: Long,
    name: String,
    price: String,
    returnUrl: String,
    status: String,
    test: Boolean,
    updateAt: Long
)
