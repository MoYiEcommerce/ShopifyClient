package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.shared.models.{
  AmountSet,
  ClientDetails,
  DiscountApplication,
  LineItem,
  NoteAttribute,
  PaymentDetail,
  PaymentTerms,
  ShippingLine,
  TaxLine
}
import com.moyiecomm.shopify.api.shippingFulfillment.Fulfillment
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class Order(
    id: Option[Long],
    appId: Option[Long],
    browserIp: Option[String],
    buyerAcceptsMarketing: Option[Boolean],
    cancelReason: Option[String],
    cancelledAt: Option[ZonedDateTime],
    cartToken: Option[String],
    clientDetails: Option[ClientDetails],
    closedAt: Option[ZonedDateTime],
    createdAt: Option[ZonedDateTime],
    currency: Option[String],
    currentSubtotalPrice: Option[String],
    currentSubtotalPriceSet: Option[AmountSet],
    currentTotalDiscounts: Option[String],
    currentTotalDiscountsSet: Option[AmountSet],
    currentTotalDutiesSet: Option[AmountSet],
    currentTotalPrice: Option[String],
    currentTotalPriceSet: Option[AmountSet],
    currentTotalTax: Option[String],
    currentTotalTaxSet: Option[AmountSet],
    customerLocale: Option[String],
    discountCodes: List[DiscountCode],
    email: Option[String],
    estimatedTaxes: Option[Boolean],
    financialStatus: Option[String],
    fulfillmentStatus: Option[String],
    landingSite: Option[String],
    locationId: Option[Long],
    name: Option[String],
    note: Option[String],
    noteAttributes: List[NoteAttribute],
    number: Option[Int],
    orderNumber: Option[Int],
    orderStatusUrl: Option[String],
    originalTotalDutiesSet: Option[AmountSet],
    phone: Option[String],
    presentmentCurrency: Option[String],
    processedAt: Option[ZonedDateTime],
    processingMethod: Option[String],
    referringSite: Option[String],
    sourceName: Option[String],
    subtotalPrice: Option[String],
    subtotalPriceSet: Option[AmountSet],
    tags: Option[String],
    taxLines: List[TaxLine],
    taxesIncluded: Option[Boolean],
    test: Option[Boolean],
    token: Option[String],
    totalDiscounts: Option[String],
    totalDiscountsSet: Option[AmountSet],
    totalLineItemsPrice: Option[String],
    totalLineItemsPriceSet: Option[AmountSet],
    totalPrice: Option[String],
    totalPriceSet: Option[AmountSet],
    totalShippingPriceSet: Option[AmountSet],
    totalTax: Option[String],
    totalTaxSet: Option[AmountSet],
    totalTipReceived: Option[String],
    totalWeight: Option[Double],
    updatedAt: Option[ZonedDateTime],
    userId: Option[Long],
    billingAddress: Option[Address],
    customer: Option[Customer],
    discountApplications: List[DiscountApplication],
    fulfillments: List[Fulfillment],
    lineItems: List[LineItem],
    paymentDetails: Option[PaymentDetail],
    refunds: List[Refund],
    shippingAddress: Option[Address],
    shippingLines: List[ShippingLine],
    paymentTerms: Option[PaymentTerms]
)

object Order extends CirceConfig with CustomizedCollectionCodec {
  val orderEncoder: Encoder[Order] = {
    implicit val addressEncoder: Encoder[Address]           = deriveConfiguredEncoder[Address]
    implicit val customerEncoder: Encoder[Customer]         = deriveConfiguredEncoder[Customer]
    implicit val discountCodeEncoder: Encoder[DiscountCode] = deriveConfiguredEncoder[DiscountCode]
    implicit val transactionEncoder: Encoder[Transaction]   = deriveConfiguredEncoder[Transaction]
    implicit val fulfillmentEncoder: Encoder[Fulfillment]   = deriveConfiguredEncoder[Fulfillment]
    implicit val refundEncoder: Encoder[Refund]             = deriveConfiguredEncoder[Refund]
    deriveConfiguredEncoder[Order].mapJson(json =>
      Json.obj(("order", json.dropEmptyValues.dropNullValues.dropEmptyString.deepDropNullValues))
    )
  }

  val orderDecoder: Decoder[Order] = {
    implicit val addressDecoder: Decoder[Address]           = deriveConfiguredDecoder[Address]
    implicit val discountCodeDecoder: Decoder[DiscountCode] = deriveConfiguredDecoder[DiscountCode]
    implicit val customerDecoder: Decoder[Customer]         = deriveConfiguredDecoder[Customer]
    implicit val transactionDecoder: Decoder[Transaction]   = deriveConfiguredDecoder[Transaction]
    implicit val fulfillmentDecoder: Decoder[Fulfillment]   = deriveConfiguredDecoder[Fulfillment]
    implicit val refundDecoder: Decoder[Refund]             = deriveConfiguredDecoder[Refund]
    deriveConfiguredDecoder[Order].prepare(_.downField("order"))
  }

  val orderListDecoder: Decoder[List[Order]] = {
    implicit val addressDecoder: Decoder[Address]           = deriveConfiguredDecoder[Address]
    implicit val discountCodeDecoder: Decoder[DiscountCode] = deriveConfiguredDecoder[DiscountCode]
    implicit val customerDecoder: Decoder[Customer]         = deriveConfiguredDecoder[Customer]
    implicit val transactionDecoder: Decoder[Transaction]   = deriveConfiguredDecoder[Transaction]
    implicit val fulfillmentDecoder: Decoder[Fulfillment]   = deriveConfiguredDecoder[Fulfillment]
    implicit val refundDecoder: Decoder[Refund]             = deriveConfiguredDecoder[Refund]
    implicit val orderDecoder: Decoder[Order]               = deriveConfiguredDecoder[Order]
    new Decoder[List[Order]] {
      override def apply(c: HCursor): Result[List[Order]] = c.get[List[Order]]("orders")
    }
  }
}
