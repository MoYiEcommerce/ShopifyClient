package com.moyiecomm.shopify.api.inventory.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.ZonedDateTime

case class Location(
    id: Long,
    name: String,
    address1: Option[String],
    address2: Option[String],
    city: Option[String],
    zip: Option[String],
    province: Option[String],
    country: Option[String],
    phone: Option[String],
    countryCode: Option[String],
    provinceCode: Option[String],
    legacy: Option[Boolean],
    active: Option[Boolean],
    localizedCountryName: Option[String],
    localizedProvinceName: Option[String],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Location extends CirceConfig {
  val locationListDecoder: Decoder[List[Location]] = {
    implicit val locationDecoder: Decoder[Location] = deriveConfiguredDecoder[Location]
    new Decoder[List[Location]] {
      override def apply(c: HCursor): Result[List[Location]] = c.get[List[Location]]("locations")
    }
  }

  val locationDecoder: Decoder[Location] = new Decoder[Location] {
    override def apply(c: HCursor): Result[Location] = c.get[Location]("location")(deriveConfiguredDecoder)
  }
}
