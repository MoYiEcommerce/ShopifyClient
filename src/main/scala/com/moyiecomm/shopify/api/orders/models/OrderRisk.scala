package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, HCursor, Json}

case class OrderRisk(
    id: Option[Long],
    orderId: Long,
    checkoutId: Option[Long],
    source: String,
    score: Double,
    recommendation: String,
    display: Boolean,
    causeCancel: Boolean,
    message: String,
    merchantMessage: Option[String]
)

object OrderRisk extends CirceConfig {
  val orderRiskEncoder: Encoder[OrderRisk] = new Encoder[OrderRisk] {
    override def apply(a: OrderRisk): Json = Json.obj(
      ("risk", a.asJson(deriveConfiguredEncoder).dropNullValues.dropEmptyValues.dropEmptyString.dropField("order_id"))
    )
  }

  val orderRiskDecoder: Decoder[OrderRisk] = deriveConfiguredDecoder[OrderRisk].prepare(_.downField("risk"))

  val orderRiskListDecoder: Decoder[List[OrderRisk]] = {
    implicit val orderRiskDecoder: Decoder[OrderRisk] = deriveConfiguredDecoder[OrderRisk]
    new Decoder[List[OrderRisk]] {
      override def apply(c: HCursor): Result[List[OrderRisk]] = c.get[List[OrderRisk]]("risks")
    }
  }
}
