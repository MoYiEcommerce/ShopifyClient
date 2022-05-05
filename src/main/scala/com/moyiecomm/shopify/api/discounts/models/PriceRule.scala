package com.moyiecomm.shopify.api.discounts.models

import com.moyiecomm.shopify.api.discounts.models.PriceRule._

case class PriceRule(
    allocationMethod: String,
    createAt: Long,
    updateAt: Long,
    customerSelection: String,
    endsAt: Long,
    entitledCollectionIds: List[Long],
    entitledCountryIds: List[Long],
    entitledProductIds: List[Long],
    entitledVariantIds: List[Long],
    id: Long,
    oncePerCustomer: Boolean,
    prerequisiteCustomerIds: List[Long],
    prerequisiteQuantityRange: PrerequisiteQuantityRange,
    prerequisiteSavedSearchIds: List[Long],
    prerequisiteShippingPriceRange: PrerequisiteShippingPriceRange,
    prerequisiteSubtotalRange: PrerequisiteSubtotalRange,
    prerequisiteToEntitlementPurchase: PrerequisiteToEntitlementPurchase,
    startsAt: Long,
    targetSelection: String,
    targetType: String,
    title: String,
    usageLimit: Int,
    prerequisiteProductIds: List[Long],
    prerequisiteVariantIds: List[Long],
    prerequisiteCollectionIds: List[Long],
    value: Int,
    valueType: String,
    prerequisiteToEntitlementQuantityRatio: PrerequisiteToEntitlementQuantityRatio,
    allocationLimit: Int
)

object PriceRule {
  case class PrerequisiteQuantityRange(greaterThanOrEqualTo: String)
  case class PrerequisiteShippingPriceRange(lessThanOrEqualTo: String)
  case class PrerequisiteSubtotalRange(greaterThanOrEqualTo: String)
  case class PrerequisiteToEntitlementPurchase(prerequisiteAmount: String)
  case class PrerequisiteToEntitlementQuantityRatio(
      prerequisiteQuantity: Int,
      entitledQuantity: Int
  )
}
