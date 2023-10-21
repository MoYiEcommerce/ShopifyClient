package com.moyiecomm.shopify.api.v1.salesChannels

import com.moyiecomm.shopify.api.v1.customers.models.Address
import com.moyiecomm.shopify.api.v1.orders.models.Order
import com.moyiecomm.shopify.api.v1.plus.GiftCard
import com.moyiecomm.shopify.api.v1.shared.models.{AppliedDiscount, LineItem, ShippingLine, TaxLine}

case class Checkout(
    appliedDiscount: AppliedDiscount,
    billingAddress: Address,
    buyerAcceptsMarketing: Boolean,
    createdAt: Long,
    currency: String,
    customerId: Long,
    discountCode: String,
    email: String,
    giftCards: List[GiftCard],
    lineItems: List[LineItem],
    order: Order,
    paymentDue: String,
    paymentUrl: String,
    phone: String,
    presentmentCurrency: String,
    requiresShipping: Boolean,
    shippingAddress: Address,
    shippingLine: ShippingLine,
    shippingRate: ShippingRate,
    sourceName: String,
    subtotalPrice: String,
    taxLines: List[TaxLine],
    taxIncluded: Boolean,
    token: String,
    totalPrice: String,
    totalTax: String,
    updatedAt: Long,
    userId: Long,
    webUrl: String
)
