package com.moyiecomm.shopify.api.v1.shared.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.generic.extras.semiauto._
import io.circe._

// todo {greater_than_or_equal_to: null} => None: Option[GreaterThanOrEqualTo] also for other [Condition] types
object Conditions extends CirceConfig {
  case class GreaterThanOrEqualTo(greaterThanOrEqualTo: Option[Double])
  case class LessThanOrEqualTo(lessThanOrEqualTo: Option[Double])
  case class PrerequisiteAmount(prerequisiteAmount: Option[Double])
  case class PrerequisiteToEntitlementQuantityRatio(prerequisiteQuantity: Option[Int], entitledQuantity: Option[Int])

  implicit val greaterThanOrEqualToEncoder: Encoder[GreaterThanOrEqualTo]    = deriveConfiguredEncoder[GreaterThanOrEqualTo]
  implicit val greaterThanOrEqualToOptDecoder: Decoder[GreaterThanOrEqualTo] = deriveConfiguredDecoder[GreaterThanOrEqualTo]

  implicit val lessThanOrEqualToEncoder: Encoder[LessThanOrEqualTo] = deriveConfiguredEncoder[LessThanOrEqualTo]
  implicit val lessThanOrEqualToDecoder: Decoder[LessThanOrEqualTo] = deriveConfiguredDecoder[LessThanOrEqualTo]

  implicit val prerequisiteAmountEncoder: Encoder[PrerequisiteAmount] = deriveConfiguredEncoder[PrerequisiteAmount]
  implicit val prerequisiteAmountDecoder: Decoder[PrerequisiteAmount] = deriveConfiguredDecoder[PrerequisiteAmount]

  implicit val prerequisiteToEntitlementQuantityRatioEncoder: Encoder[PrerequisiteToEntitlementQuantityRatio] =
    deriveConfiguredEncoder[PrerequisiteToEntitlementQuantityRatio]
  implicit val prerequisiteToEntitlementQuantityRatioDecoder: Decoder[PrerequisiteToEntitlementQuantityRatio] =
    deriveConfiguredDecoder[PrerequisiteToEntitlementQuantityRatio]
}
