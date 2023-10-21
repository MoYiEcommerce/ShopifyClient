package com.moyiecomm.shopify.api.v1.orders.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.json.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.v1.shared.models._
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class Transaction(
    id: Option[Long],
    orderId: Option[Long],
    kind: Option[String],
    gateway: Option[String],
    status: Option[String],
    message: Option[String],
    createdAt: Option[ZonedDateTime],
    test: Option[Boolean],
    authorization: Option[String],
    locationId: Option[Long],
    userId: Option[Long],
    parentId: Option[Long],
    processedAt: Option[ZonedDateTime],
    sourceName: Option[String],
    deviceId: Option[Int],
    errorCode: Option[String],
    paymentDetails: Option[PaymentDetail],
    currencyExchangeAdjustment: Option[CurrencyExchangeAdjustment],
    amount: Option[String],
    paymentsRefundAttributes: Option[PaymentRefundAttribute],
    currency: Option[String],
    authorizationExpiresAt: Option[Long],
    extendedAuthorizationAttributes: Option[ExtendedAuthorizationAttribute],
    maximumRefundable: Option[Double]
)

object Transaction extends CirceConfig with CustomizedCollectionCodec {
  val transactionEncoder: Encoder[Transaction] = deriveConfiguredEncoder[Transaction].mapJson(json =>
    Json.obj(("transaction", json.dropNullValues.dropEmptyValues.dropField("order_id").deepDropNullValues))
  )

  val transactionDecoder: Decoder[Transaction] = deriveConfiguredDecoder[Transaction].prepare(_.downField("transaction"))

  val transactionListDecoder: Decoder[List[Transaction]] = {
    implicit val transactionDecoder: Decoder[Transaction] = deriveConfiguredDecoder[Transaction]
    new Decoder[List[Transaction]] {
      override def apply(c: HCursor): Result[List[Transaction]] = c.get[List[Transaction]]("transactions")
    }
  }
}
