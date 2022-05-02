package com.moyiecomm.shopify.api.customers.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class Address(
    id: Option[Long],
    customerId: Option[Long],
    address1: String,
    address2: Option[String],
    city: String,
    province: String,
    phone: String,
    zip: String,
    company: Option[String],
    lastName: Option[String],
    firstName: Option[String],
    country: String,
    name: Option[String],
    provinceCode: Option[String],
    countryCode: Option[String],
    countryName: Option[String],
    latitude: Option[String],
    longitude: Option[String],
    default: Option[Boolean]
)

object Address extends CirceConfig {
  val addressEncoder: Encoder[Address] = new Encoder[Address] {
    override def apply(a: Address): Json = Json.obj(
      (
        "address",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
          .dropField("customer_id")
      )
    )
  }

  val addressDecoder: Decoder[Address] = new Decoder[Address] {
    override def apply(c: HCursor): Result[Address] = c.get[Address]("customer_address")(deriveConfiguredDecoder)
  }

  val addressListDecoder: Decoder[List[Address]] = {
    implicit val addressDecoder: Decoder[Address] = deriveConfiguredDecoder[Address]
    new Decoder[List[Address]] {
      override def apply(c: HCursor): Result[List[Address]] = c.get[List[Address]]("addresses")
    }
  }
}
