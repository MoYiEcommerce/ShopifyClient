package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.shared.models.{Duty, OrderAdjustment, RefundDuty, RefundLineItem}
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class Refund(
    id: Option[Long],
    userId: Option[Long],
    note: Option[String],
    duties: List[Duty],
    orderAdjustments: List[OrderAdjustment],
    transactions: List[Transaction],
    refundDuties: List[RefundDuty],
    refundLineItems: List[RefundLineItem],
    createdAt: Option[ZonedDateTime],
    processedAt: Option[ZonedDateTime]
)

object Refund extends CirceConfig with CustomizedCollectionCodec {
//  val refundEncoder: Encoder[Refund] = deriveConfiguredEncoder[Refund].mapJson(json =>
//    Json.obj(("refund", json.dropNullValues.dropEmptyValues.dropEmptyString.deepDropNullValues))
//  )
//
//  val refundDecoder: Decoder[Refund] = deriveConfiguredDecoder[Refund].prepare(_.downField("refund"))

  val refundEncoder: Encoder[Refund] = ???
  val refundDecoder: Decoder[Refund] = ???
}
