package com.moyiecomm.shopify.api.json.billing

import java.time.ZonedDateTime

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.json.shared.Status
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class ApplicationCharge(
    confirmationUrl: Option[String],
    createdAt: Option[ZonedDateTime],
    id: Option[Long],
    apiClientId: Option[Long],
    name: String,
    price: Double,
    returnUrl: Option[String],
    status: Option[Status],
    chargeType: Option[String],
    decoratedReturnUrl: Option[String],
    test: Option[Boolean],
    updatedAt: Option[ZonedDateTime]
)

object ApplicationCharge extends CirceConfig {

  val applicationChargeEncoder: Encoder[ApplicationCharge] = new Encoder[ApplicationCharge] {
    override def apply(a: ApplicationCharge): Json = Json.obj(
      (
        "application_charge",
        Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString
      )
    )
  }

  val applicationChargeDecoder: Decoder[ApplicationCharge] = new Decoder[ApplicationCharge] {
    override def apply(c: HCursor): Result[ApplicationCharge] =
      c.get[ApplicationCharge]("application_charge")(deriveConfiguredDecoder)
  }

  val applicationChargeListDecoder: Decoder[List[ApplicationCharge]] = {
    implicit val applicationChargeDecoder: Decoder[ApplicationCharge] = deriveConfiguredDecoder[ApplicationCharge]
    new Decoder[List[ApplicationCharge]] {
      override def apply(c: HCursor): Result[List[ApplicationCharge]] = c.get[List[ApplicationCharge]]("application_charges")
    }
  }
}
