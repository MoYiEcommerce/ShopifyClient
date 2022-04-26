package com.moyiecomm.shopify.api.salesChannels

import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.orders.AppliedDiscount
import com.moyiecomm.shopify.api.orders.LineItem
import com.moyiecomm.shopify.api.orders.Order
import com.moyiecomm.shopify.api.orders.ShippingLine
import com.moyiecomm.shopify.api.orders.TaxLine
import com.moyiecomm.shopify.api.plus.GiftCard

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
