package com.moyiecomm.shopify.api.access.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, HCursor, Json}

case class StorefrontAccessToken(
    id: Long,
    accessToken: String,
    accessScope: String,
    createdAt: Long,
    title: String
)

object StorefrontAccessToken extends CirceConfig {
  implicit val storefrontAccessTokenEncoder: Encoder[StorefrontAccessToken] = new Encoder[StorefrontAccessToken] {
    override def apply(a: StorefrontAccessToken): Json = Json.obj(
      ("collect", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val storefrontAccessTokenDecoder: Decoder[StorefrontAccessToken] = new Decoder[StorefrontAccessToken] {
    override def apply(c: HCursor): Result[StorefrontAccessToken] =
      c.get[StorefrontAccessToken]("storefront_access_token")(deriveConfiguredDecoder)
  }
}
