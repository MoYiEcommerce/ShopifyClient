package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class CurrencyExchangeAdjustment(id: Long, adjustment: Double, originalAmount: Double, finalAmount: Double, currency: String)

object CurrencyExchangeAdjustment extends CirceConfig {
  implicit val currencyExchangeAdjustmentEncoder: Encoder[CurrencyExchangeAdjustment] =
    deriveConfiguredEncoder[CurrencyExchangeAdjustment]
  implicit val currencyExchangeAdjustmentDecoder: Decoder[CurrencyExchangeAdjustment] =
    deriveConfiguredDecoder[CurrencyExchangeAdjustment]
}
