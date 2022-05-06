package com.moyiecomm.shopify.api.discounts.models

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.shared.models.Conditions.{
  GreaterThanOrEqualTo,
  LessThanOrEqualTo,
  PrerequisiteAmount,
  PrerequisiteToEntitlementQuantityRatio
}
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.ZonedDateTime

case class PriceRule(
    allocationMethod: String,
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime],
    customerSelection: String,
    endsAt: Option[ZonedDateTime],
    entitledCollectionIds: List[Long],
    entitledCountryIds: List[Long],
    entitledProductIds: List[Long],
    entitledVariantIds: List[Long],
    id: Option[Long],
    oncePerCustomer: Option[Boolean],
    prerequisiteCustomerIds: List[Long],
    prerequisiteQuantityRange: Option[GreaterThanOrEqualTo],
    customerSegmentPrerequisiteIds: List[Long],
    prerequisiteShippingPriceRange: Option[LessThanOrEqualTo],
    prerequisiteSubtotalRange: Option[GreaterThanOrEqualTo],
    prerequisiteToEntitlementPurchase: Option[PrerequisiteAmount],
    startsAt: Option[ZonedDateTime],
    targetSelection: String,
    targetType: String,
    title: String,
    usageLimit: Option[Int],
    prerequisiteProductIds: List[Long],
    prerequisiteVariantIds: List[Long],
    prerequisiteCollectionIds: List[Long],
    value: Double,
    valueType: String,
    prerequisiteToEntitlementQuantityRatio: Option[PrerequisiteToEntitlementQuantityRatio],
    allocationLimit: Option[Int]
)

object PriceRule extends CirceConfig {

  val priceRuleEncoder: Encoder[PriceRule] = new Encoder[PriceRule] {
    override def apply(a: PriceRule): Json =
      Json.obj(
        (
          "price_rule",
          Json
            .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
            .dropNullValues
            .dropEmptyValues
            .dropEmptyString
            .deepMerge(Json.obj(("value", Json.fromString(a.value.toString))))
        )
      )
  }

  val priceRuleDecoder: Decoder[PriceRule] = {
    new Decoder[PriceRule] {
      override def apply(c: HCursor): Result[PriceRule] =
        c.get[PriceRule]("price_rule")(deriveConfiguredDecoder)
    }
  }

  val priceRuleListDecoder: Decoder[List[PriceRule]] = {
    implicit val priceRuleDecoder: Decoder[PriceRule] = deriveConfiguredDecoder[PriceRule]
    new Decoder[List[PriceRule]] {
      override def apply(c: HCursor): Result[List[PriceRule]] = c.get[List[PriceRule]]("price_rules")
    }
  }
}
