package com.moyiecomm.shopify.api.discounts

case class DiscountCode(
    code: String,
    createAt: Long,
    updateAt: Long,
    id: Long,
    priceRuleId: Long,
    usageCount: Int
)
