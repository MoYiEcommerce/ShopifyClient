package com.moyiecomm.shopify.api.v1.access.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, HCursor, Json}

import java.time.ZonedDateTime

case class StorefrontAccessToken(
    id: Option[Long],
    accessToken: Option[String],
    accessScope: Option[String],
    createdAt: Option[ZonedDateTime],
    title: String
)

object StorefrontAccessToken extends CirceConfig {
  val storefrontAccessTokenEncoder: Encoder[StorefrontAccessToken] = new Encoder[StorefrontAccessToken] {
    override def apply(a: StorefrontAccessToken): Json = Json.obj(
      (
        "storefront_access_token",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString
      )
    )
  }

  val storefrontAccessTokenDecoder: Decoder[StorefrontAccessToken] = new Decoder[StorefrontAccessToken] {
    override def apply(c: HCursor): Result[StorefrontAccessToken] =
      c.get[StorefrontAccessToken]("storefront_access_token")(deriveConfiguredDecoder)
  }

  val storefrontAccessTokenListDecoder = {
    implicit val storefrontAccessTokenDecoder: Decoder[StorefrontAccessToken] = deriveConfiguredDecoder[StorefrontAccessToken]
    new Decoder[List[StorefrontAccessToken]] {
      override def apply(c: HCursor): Result[List[StorefrontAccessToken]] =
        c.get[List[StorefrontAccessToken]]("storefront_access_tokens")
    }
  }
}
