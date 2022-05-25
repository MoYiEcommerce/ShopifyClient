package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class MarketingConsent(
    state: String,
    optInLevel: Option[String],
    consentUpdatedAt: Option[ZonedDateTime],
    consentCollectedFrom: Option[String]
)

object MarketingConsent extends CirceConfig {
  implicit val smsMarketingConsentEncoder: Encoder[MarketingConsent] =
    deriveConfiguredEncoder[MarketingConsent].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)
  implicit val smsMarketingConsentDecoder: Decoder[MarketingConsent] = deriveConfiguredDecoder[MarketingConsent]
}
