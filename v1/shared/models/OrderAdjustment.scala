package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class OrderAdjustment(
    id: Long,
    orderId: Long,
    refundId: Long,
    amount: Double,
    taxAmount: Double,
    kind: String,
    reason: String,
    amountSet: AmountSet,
    taxAmountSet: AmountSet
)

object OrderAdjustment extends CirceConfig {
  implicit val orderAdjustmentEncoder: Encoder[OrderAdjustment] = deriveConfiguredEncoder[OrderAdjustment]
  implicit val orderAdjustmentDecoder: Decoder[OrderAdjustment] = deriveConfiguredDecoder[OrderAdjustment]
}
