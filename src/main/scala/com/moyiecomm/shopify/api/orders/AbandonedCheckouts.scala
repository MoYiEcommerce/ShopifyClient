package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.customers.Address
import com.moyiecomm.shopify.api.customers.Customer
import com.moyiecomm.shopify.api.discounts.DiscountCode

case class AbandonedCheckouts(
    abandonedCheckoutUrl: String,
    billingAddress: Address,
    buyerAcceptMarketing: Boolean,
    buyerAcceptSmsMarketing: Boolean,
    cartToken: String,
    closedAt: Long,
    completedAt: Long,
    createdAt: Long,
    currency: String,
    customer: Customer,
    customerLocation: String,
    deviceId: Long,
    discountCodes: List[DiscountCode],
    email: String,
    gateway: String,
    id: Long,
    landingSite: String,
    lineItems: List[LineItem],
    locationId: Int,
    note: String,
    phone: String,
    presentmentCurrency: String,
    referringSite: String,
    shippingAddress: Address,
    smsMarketingPhone: String,
    shippingLines: ShippingLine,
    sourceName: String,
    subtotalPrice: String,
    taxLines: TaxLine,
    taxesIncluded: Boolean,
    token: String,
    totalDiscounts: String,
    totalDuties: String,
    totalLineItemsPrice: String,
    totalPrice: String,
    totalTax: String,
    totalWeight: Int,
    updatedAt: Long,
    userId: Long
)
