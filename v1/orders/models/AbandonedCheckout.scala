package com.moyiecomm.shopify.api.v1.orders.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.json.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.v1.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.v1.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.v1.shared.models.{LineItem, NoteAttribute, ShippingLine, TaxLine}
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._

import java.time.ZonedDateTime

case class AbandonedCheckout(
    id: Long,
    abandonedCheckoutUrl: String,
    token: String,
    cartToken: String,
    email: String,
    gateway: Option[String],
    billingAddress: Address,
    buyerAcceptsMarketing: Option[Boolean],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime],
    landingSite: Option[String],
    note: Option[String],
    noteAttributes: List[NoteAttribute],
    buyerAcceptSmsMarketing: Option[Boolean],
    closedAt: Option[ZonedDateTime],
    completedAt: Option[ZonedDateTime],
    currency: Option[String],
    customer: Customer,
    customerLocale: Option[String],
    deviceId: Option[Long],
    discountCodes: List[DiscountCode],
    lineItems: List[LineItem],
    locationId: Option[Long],
    phone: Option[String],
    presentmentCurrency: String,
    referringSite: Option[String],
    shippingAddress: Address,
    smsMarketingPhone: Option[String],
    shippingLines: List[ShippingLine],
    sourceName: String,
    subtotalPrice: Double,
    taxLines: List[TaxLine],
    taxesIncluded: Option[Boolean],
    totalDiscounts: Option[Double],
    totalDuties: Option[String],
    totalLineItemsPrice: Option[Double],
    totalPrice: Option[Double],
    totalTax: Option[Double],
    totalWeight: Option[Int],
    userId: Option[Long]
)

object AbandonedCheckout extends CirceConfig with CustomizedCollectionCodec {
  val abandonedCheckoutListDecoder: Decoder[List[AbandonedCheckout]] = {
    implicit val addressDecoder: Decoder[Address]                     = deriveConfiguredDecoder[Address]
    implicit val discountCodeDecoder: Decoder[DiscountCode]           = deriveConfiguredDecoder[DiscountCode]
    implicit val customerDecoder: Decoder[Customer]                   = deriveConfiguredDecoder[Customer]
    implicit val abandonedCheckoutDecoder: Decoder[AbandonedCheckout] = deriveConfiguredDecoder[AbandonedCheckout]

    new Decoder[List[AbandonedCheckout]] {
      override def apply(c: HCursor): Result[List[AbandonedCheckout]] = c.get[List[AbandonedCheckout]]("checkouts")
    }
  }
}
