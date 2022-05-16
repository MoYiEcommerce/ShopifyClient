package com.moyiecomm.shopify.api.discounts.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe._

import java.time.ZonedDateTime

case class DiscountCode(
    id: Option[Long],
    code: String,
    usageCount: Option[Int],
    amount: Option[Double],
    `type`: Option[String],
    priceRuleId: Option[Long],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object DiscountCode extends CirceConfig {
  val discountCodeListEncoder: Encoder[List[DiscountCode]] = new Encoder[List[DiscountCode]] {
    override def apply(a: List[DiscountCode]): Json = Json.obj(
      (
        "discount_codes",
        Json.fromValues(
          a.map(dc =>
            Json
              .fromJsonObject(dc.asJsonObject(deriveConfiguredEncoder))
              .dropNullValues
              .dropEmptyValues
              .dropEmptyString
              .dropField("errors")
          )
        )
      )
    )
  }

  val discountCodeEncoder: Encoder[DiscountCode] = new Encoder[DiscountCode] {
    override def apply(a: DiscountCode): Json = Json.obj(
      (
        "discount_code",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
      )
    )
  }

  val discountCodeDecoder: Decoder[DiscountCode] = new Decoder[DiscountCode] {
    override def apply(c: HCursor): Result[DiscountCode] = c.get[DiscountCode]("discount_code")(deriveConfiguredDecoder)
  }

  val discountCodeListDecoder: Decoder[List[DiscountCode]] = {
    implicit val discountCodeDecoder: Decoder[DiscountCode] = deriveConfiguredDecoder[DiscountCode]
    new Decoder[List[DiscountCode]] {
      override def apply(c: HCursor): Result[List[DiscountCode]] = c.get[List[DiscountCode]]("discount_codes")
    }
  }
}
