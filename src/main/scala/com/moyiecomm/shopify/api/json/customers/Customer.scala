package com.moyiecomm.shopify.api.json.customers

import java.time.ZonedDateTime

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.json.customers.Customer.Metafield
import com.moyiecomm.shopify.api.json.shared.MarketingConsent
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

case class Customer(
    id: Option[Long],
    firstName: String,
    lastName: String,
    email: String,
    phone: Option[String],
    verifiedEmail: Option[Boolean],
    acceptsMarketing: Option[Boolean],
    acceptsMarketingUpdatedAt: Option[ZonedDateTime],
    addresses: List[Address],
    currency: Option[String],
    defaultAddress: Option[Address],
    lastOrderId: Option[Long],
    lastOrderName: Option[String],
    metafield: Option[Metafield],
    marketingOptInLevel: Option[String],
    multipassIdentifier: Option[String],
    note: Option[String],
    ordersCount: Option[Int],
    smsMarketingConsent: Option[MarketingConsent],
    emailMarketingConsent: Option[MarketingConsent],
    smsTransactionalConsent: Option[MarketingConsent],
    state: Option[String],
    tags: Option[String],
    taxExempt: Option[Boolean],
    tax_exemptions: List[String],
    totalSpent: Option[Double],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Customer extends CirceConfig {
  case class Metafield(
      key: String,
      namespace: String,
      value: String,
      valueType: String,
      description: Option[String]
  )

  implicit val metafieldEncoder: Encoder[Metafield] = deriveConfiguredEncoder[Metafield]
  implicit val metafieldDecoder: Decoder[Metafield] = deriveConfiguredDecoder[Metafield]

  val customerEncoder: Encoder[Customer] = new Encoder[Customer] {
    implicit val addressEncoder: Encoder[Address] = deriveConfiguredEncoder[Address]
    override def apply(a: Customer): Json = Json.obj(
      (
        "customer",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
          .deepDropNullValues
      )
    )
  }

  val customerDecoder: Decoder[Customer] = new Decoder[Customer] {
    implicit val addressDecoder: Decoder[Address] = deriveConfiguredDecoder[Address]
    override def apply(c: HCursor): Result[Customer] =
      c.get[Customer]("customer")(deriveConfiguredDecoder)
  }

  val customerListDecoder: Decoder[List[Customer]] = {
    implicit val addressDecoder: Decoder[Address]   = deriveConfiguredDecoder[Address]
    implicit val customerDecoder: Decoder[Customer] = deriveConfiguredDecoder[Customer]
    new Decoder[List[Customer]] {
      override def apply(c: HCursor): Result[List[Customer]] = c.get[List[Customer]]("customers")
    }
  }
}
