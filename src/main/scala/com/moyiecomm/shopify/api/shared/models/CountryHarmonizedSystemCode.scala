package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.generic.extras.semiauto._
import io.circe._

case class CountryHarmonizedSystemCode(countryCode: String, harmonizedSystemCode: String)

object CountryHarmonizedSystemCode extends CirceConfig {
  implicit val countryHarmonizedSystemCodeEncoder: Encoder[CountryHarmonizedSystemCode] =
    deriveConfiguredEncoder[CountryHarmonizedSystemCode]
  implicit val countryHarmonizedSystemCodeDecoder: Decoder[CountryHarmonizedSystemCode] =
    deriveConfiguredDecoder[CountryHarmonizedSystemCode]
}
