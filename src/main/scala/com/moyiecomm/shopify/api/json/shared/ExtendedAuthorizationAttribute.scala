package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class ExtendedAuthorizationAttribute(
    standardAuthorizationExpiresAt: ZonedDateTime,
    extendedAuthorizationExpiresAt: ZonedDateTime
)

object ExtendedAuthorizationAttribute extends CirceConfig {
  implicit val extendedAuthorizationAttributeEncoder: Encoder[ExtendedAuthorizationAttribute] =
    deriveConfiguredEncoder[ExtendedAuthorizationAttribute]
  implicit val extendedAuthorizationAttributeDecoder: Decoder[ExtendedAuthorizationAttribute] =
    deriveConfiguredDecoder[ExtendedAuthorizationAttribute]
}
