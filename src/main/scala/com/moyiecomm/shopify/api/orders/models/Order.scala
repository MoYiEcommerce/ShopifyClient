package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.orders.models.Order._
import com.moyiecomm.shopify.api.shared.models.{LineItem, NoteAttribute, PaymentTerms, ShippingLine, TaxLine, PaymentDetail}

case class Order(
    appId: Long,
    billingAddress: Address,
    browserIp: String,
    buyerAcceptsMarketing: Boolean,
    cancelReason: String,
    cancelledAt: Long,
    cartToken: String,
    clientDetails: ClientDetails,
    closedAt: Long,
    createdAt: Long,
    currency: String,
    currentTotalDiscounts: String,
    currentTotalDiscountsSet: CurrentTotalDiscountsSet,
    currentTotalDutiesSet: CurrentTotalDutiesSet,
    currentTotalPrice: String,
    currentTotalPriceSet: CurrentTotalPriceSet,
    currentSubtotalPrice: String,
    currentSubtotalPriceSet: CurrentSubtotalPriceSet,
    currentTotalTax: String,
    currentTotalTaxSet: CurrentTotalTaxSet,
    customer: Customer,
    customerLocale: String,
    discountApplications: List[DiscountApplication],
    discountCodes: List[DiscountCode],
    email: String,
    estimatedTaxes: Boolean,
    financialStatus: String,
    fulfillments: List[Fullfillment],
    fulfillmentStatus: String,
    id: Long,
    landingSite: String,
    lineItems: List[LineItem],
    locationId: Long,
    name: String,
    note: String,
    noteAttributes: List[NoteAttribute],
    number: Int,
    orderNumber: Int,
    originalTotalDutiesSet: OriginalTotalDutiesSet,
    paymentDetails: PaymentDetail,
    paymentTerms: PaymentTerms,
    phone: String,
    presentmentCurrency: String,
    processedAt: Long,
    processingMethod: String,
    referringSite: String,
    refunds: List[Refund],
    shippingAddress: Address,
    shippingLInes: List[ShippingLine],
    sourceName: String,
    subtotalPrice: String,
    subtotalPriceSet: SubtotalPriceSet,
    tags: String,
    taxLines: List[TaxLine],
    taxesIncluded: Boolean,
    test: Boolean,
    token: String,
    totalDiscounts: String,
    totalDiscountsSet: TotalDiscountsSet,
    totalLineItemPrice: String,
    totalLineItemPriceSet: TotalLineItemPriceSet,
    totalPrice: String,
    totalPriceSet: TotalPriceSet,
    totalShippingPriceSet: TotalShippingPriceSet,
    totalTax: String,
    totalTaxSet: TotalTaxSet,
    total_tip_received: String,
    total_weight: String,
    updated_at: Long,
    userId: Long,
    orderStatusUrl: String
)

object Order {
  case class ClientDetails()
  case class CurrentTotalDiscountsSet()
  case class CurrentTotalDutiesSet()
  case class CurrentTotalPriceSet()
  case class CurrentSubtotalPriceSet()
  case class CurrentTotalTaxSet()
  case class DiscountApplication()
  case class Fullfillment()
  case class OriginalTotalDutiesSet()
  case class SubtotalPriceSet()
  case class TotalDiscountsSet()
  case class TotalLineItemPriceSet()
  case class TotalPriceSet()
  case class TotalShippingPriceSet()
  case class TotalTaxSet()
}
