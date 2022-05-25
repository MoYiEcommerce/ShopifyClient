package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.shared.models.{Duty, OrderAdjustment, RefundDuty, RefundLineItem, RefundableShipping}
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class Refund(
    id: Option[Long],
    orderId: Option[Long],
    userId: Option[Long],
    note: Option[String],
    currency: Option[String],
    restock: Option[Boolean],
    shipping: Option[RefundableShipping],
    duties: List[Duty],
    orderAdjustments: List[OrderAdjustment],
    transactions: List[Transaction],
    refundDuties: List[RefundDuty],
    refundLineItems: List[RefundLineItem],
    createdAt: Option[ZonedDateTime],
    processedAt: Option[ZonedDateTime]
)

object Refund extends CirceConfig with CustomizedCollectionCodec {
  val refundEncoder: Encoder[Refund] = {
    implicit val transactionEncoder: Encoder[Transaction] = deriveConfiguredEncoder[Transaction]
    deriveConfiguredEncoder[Refund].mapJson(json =>
      Json.obj(("refund", json.dropNullValues.dropEmptyValues.dropEmptyString.deepDropNullValues.dropField("order_id")))
    )
  }

  val refundDecoder: Decoder[Refund] = {
    implicit val transactionDecoder: Decoder[Transaction] = deriveConfiguredDecoder[Transaction]
    deriveConfiguredDecoder[Refund].prepare(_.downField("refund"))
  }

  val refundListDecoder: Decoder[List[Refund]] = {
    implicit val transactionDecoder: Decoder[Transaction] = deriveConfiguredDecoder[Transaction]
    implicit val refundDecoder: Decoder[Refund]           = deriveConfiguredDecoder[Refund]
    new Decoder[List[Refund]] {
      override def apply(c: HCursor): Result[List[Refund]] = c.get[List[Refund]]("refunds")
    }
  }
}
