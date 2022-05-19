package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedListDecoder}
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.shared.models.{AppliedDiscount, LineItem, NoteAttribute, PaymentTerms, ShippingLine, TaxLine}
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime

case class DraftOrder(
    id: Option[Long],
    orderId: Option[Long],
    name: Option[String],
    customer: Option[Customer],
    shippingAddress: Option[Address],
    billingAddress: Option[Address],
    note: Option[String],
    noteAttributes: List[NoteAttribute],
    email: Option[String],
    currency: Option[String],
    invoiceUrl: Option[String],
    invoiceSentAt: Option[ZonedDateTime],
    lineItems: List[LineItem],
    paymentTerms: Option[PaymentTerms],
    shippingLine: Option[ShippingLine],
    tags: String,
    taxExempt: Option[Boolean],
    taxExemptions: List[String],
    taxLines: List[TaxLine],
    appliedDiscount: Option[AppliedDiscount],
    taxesIncluded: Option[Boolean],
    totalTax: Option[Double],
    subtotalPrice: Option[Double],
    totalPrice: Option[Double],
    status: Option[String],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime],
    completedAt: Option[ZonedDateTime]
)

object DraftOrder extends CirceConfig with CustomizedListDecoder {
  val draftOrderEncoder: Encoder[DraftOrder] = {
    implicit val addressEncoder: Encoder[Address]   = deriveConfiguredEncoder[Address]
    implicit val customerEncoder: Encoder[Customer] = deriveConfiguredEncoder[Customer]
    new Encoder[DraftOrder] {
      override def apply(a: DraftOrder): Json = Json.obj(
        (
          "draft_order",
          Json
            .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
            .dropNullValues
            .dropEmptyValues
            .dropEmptyString
            .deepDropNullValues
            .deepDropEmptyString
        )
      )
    }
  }

  val draftOrderDecoder: Decoder[DraftOrder] = {
    implicit val addressDecoder: Decoder[Address]   = deriveConfiguredDecoder[Address]
    implicit val customerDecoder: Decoder[Customer] = deriveConfiguredDecoder[Customer]
    new Decoder[DraftOrder] {
      override def apply(c: HCursor): Result[DraftOrder] = c.get[DraftOrder]("draft_order")(deriveConfiguredDecoder)
    }
  }

  val draftOrderListDecoder: Decoder[List[DraftOrder]] = {
    implicit val addressDecoder: Decoder[Address]       = deriveConfiguredDecoder[Address]
    implicit val customerDecoder: Decoder[Customer]     = deriveConfiguredDecoder[Customer]
    implicit val draftOrderDecoder: Decoder[DraftOrder] = deriveConfiguredDecoder[DraftOrder]
    new Decoder[List[DraftOrder]] {
      override def apply(c: HCursor): Result[List[DraftOrder]] = c.get[List[DraftOrder]]("draft_orders")
    }
  }
}
