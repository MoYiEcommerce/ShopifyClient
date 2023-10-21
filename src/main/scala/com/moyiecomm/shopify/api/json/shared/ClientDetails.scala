package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class ClientDetails(
    acceptLanguage: Option[String],
    browserHeight: Option[Int],
    browserIp: Option[String],
    browserWidth: Option[Int],
    sessionHash: Option[String],
    userAgent: Option[String]
)

object ClientDetails extends CirceConfig {
  implicit val clientDetailsEncoder: Encoder[ClientDetails] = deriveConfiguredEncoder[ClientDetails]
  implicit val clientDetailsDecoder: Decoder[ClientDetails] = deriveConfiguredDecoder[ClientDetails]
}
