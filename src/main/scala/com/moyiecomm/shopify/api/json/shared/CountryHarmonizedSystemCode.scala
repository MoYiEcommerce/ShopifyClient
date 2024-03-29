package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class CountryHarmonizedSystemCode(countryCode: String, harmonizedSystemCode: String)

object CountryHarmonizedSystemCode extends CirceConfig {
  implicit val countryHarmonizedSystemCodeEncoder: Encoder[CountryHarmonizedSystemCode] =
    deriveConfiguredEncoder[CountryHarmonizedSystemCode]
  implicit val countryHarmonizedSystemCodeDecoder: Decoder[CountryHarmonizedSystemCode] =
    deriveConfiguredDecoder[CountryHarmonizedSystemCode]
}
