package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.customers.models.{Address, Customer}

case class DraftOrder(
    id: Long,
    orderId: Long,
    name: String,
    customer: Customer,
    shippingAddress: Address,
    billingAddress: Address,
    note: String,
    noteAttributes: List[NoteAttribute],
    email: String,
    currency: String,
    invoiceSentAt: Long,
    lineItems: List[LineItem],
    paymentTerms: PaymentTerm,
    shippingLine: ShippingLine,
    tags: String,
    taxExempt: Boolean,
    taxExemptions: List[String],
    taxLines: List[TaxLine],
    appliedDiscount: AppliedDiscount,
    taxesIncluded: Boolean,
    totalTax: String,
    subtotalPrice: String,
    totalPrice: String,
    completedAt: Long,
    createdAt: Long,
    updatedAt: Long,
    status: String
)
