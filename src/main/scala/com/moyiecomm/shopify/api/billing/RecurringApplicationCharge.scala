package com.moyiecomm.shopify.api.billing

case class RecurringApplicationCharge(
    activatedOn: Long,
    billingOn: Long,
    cancelledOn: Long,
    cappedAmount: String,
    confirmationUrl: String,
    createAt: Long,
    id: Long,
    name: String,
    price: Long,
    returnUrl: String,
    status: String,
    terms: String,
    test: Boolean,
    trialDays: Int,
    trialEndsOn: Long,
    updateAt: Long
)
