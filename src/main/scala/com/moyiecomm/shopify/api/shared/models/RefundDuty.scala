package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class RefundDuty(dutyId: Long, refundType: String)

object RefundDuty extends CirceConfig {
  val refundDutyEncoder: Encoder[RefundDuty] = deriveConfiguredEncoder[RefundDuty]
  val refundDutyDecoder: Decoder[RefundDuty] = deriveConfiguredDecoder[RefundDuty]
}
