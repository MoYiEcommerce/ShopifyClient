package com.moyiecomm.shopify.api.customers.models

import com.moyiecomm.shopify.api.CirceConfig
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
    lastName: Option[String],
    firstName: Option[String],
    country: String,
    countryCode: Option[String],
    countryName: Option[String],
    company: Option[String],
    latitude: Option[String],
    longitude: Option[String],
    name: Option[String],
    provinceCode: Option[String],
    default: Option[Boolean]
)

object Address extends CirceConfig {
  val addressEncoder: Encoder[Address] = new Encoder[Address] {
    override def apply(a: Address): Json = Json.obj(
      ("address", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)).dropNullValues.dropEmptyValues.dropEmptyString)
    )
  }
}
