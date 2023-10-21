package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class Duty(dutyId: Long, amountSet: AmountSet)

object Duty extends CirceConfig {
  implicit val dutyEncoder: Encoder[Duty] =
    deriveConfiguredEncoder[Duty].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString.deepDropNullValues)

  implicit val dutyDecoder: Decoder[Duty] = deriveConfiguredDecoder[Duty]
}
