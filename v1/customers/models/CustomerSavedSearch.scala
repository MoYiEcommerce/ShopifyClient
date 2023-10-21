package com.moyiecomm.shopify.api.v1.customers.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe._

import java.time.ZonedDateTime

case class CustomerSavedSearch(
    id: Option[Long],
    name: String,
    query: String,
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object CustomerSavedSearch extends CirceConfig {
  val customerSavedSearchEncoder: Encoder[CustomerSavedSearch] = new Encoder[CustomerSavedSearch] {
    override def apply(a: CustomerSavedSearch): Json = {
      Json.obj(
        (
          "customer_saved_search",
          Json
            .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
            .dropNullValues
            .dropEmptyValues
            .dropEmptyString
        )
      )
    }
  }

  val customerSavedSearchDecoder: Decoder[CustomerSavedSearch] = new Decoder[CustomerSavedSearch] {
    override def apply(c: HCursor): Result[CustomerSavedSearch] =
      c.get[CustomerSavedSearch]("customer_saved_search")(deriveConfiguredDecoder)
  }

  val customerSavedSearchListDecoder: Decoder[List[CustomerSavedSearch]] = {
    implicit val customerSavedSearchDecoder: Decoder[CustomerSavedSearch] = deriveConfiguredDecoder[CustomerSavedSearch]
    new Decoder[List[CustomerSavedSearch]] {
      override def apply(c: HCursor): Result[List[CustomerSavedSearch]] =
        c.get[List[CustomerSavedSearch]]("customer_saved_searches")
    }
  }
}
