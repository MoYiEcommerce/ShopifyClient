package com.moyiecomm.shopify.api.billing.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class ApplicationCharge(
    confirmationUrl: String,
    createAt: Long,
    id: Long,
    name: String,
    price: String,
    returnUrl: String,
    status: String,
    test: Boolean,
    updateAt: Long
)

object ApplicationCharge extends CirceConfig {
  implicit val applicationChargeEncoder: Encoder[ApplicationCharge] = new Encoder[ApplicationCharge] {
    override def apply(a: ApplicationCharge): Json = Json.obj(
      ("application_charge", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }

  implicit val applicationChargeDecoder: Decoder[ApplicationCharge] = new Decoder[ApplicationCharge] {
    override def apply(c: HCursor): Result[ApplicationCharge] =
      c.get[ApplicationCharge]("application_charge")(deriveConfiguredDecoder)
  }
}
