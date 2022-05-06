package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.PriceRule
import com.moyiecomm.shopify.api.shared.models.Conditions.{PrerequisiteAmount, PrerequisiteToEntitlementQuantityRatio}
import sttp.model.{Method, StatusCode}

class GetPriceRuleListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetPriceRuleList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/price_rules.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "price_rules": [
                      |    {
                      |      "id": 507328175,
                      |      "value_type": "fixed_amount",
                      |      "value": "-10.0",
                      |      "customer_selection": "all",
                      |      "target_type": "line_item",
                      |      "target_selection": "all",
                      |      "allocation_method": "across",
                      |      "allocation_limit": null,
                      |      "once_per_customer": false,
                      |      "usage_limit": null,
                      |      "starts_at": "2022-03-05T11:02:04-05:00",
                      |      "ends_at": "2022-03-17T11:02:04-04:00",
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "entitled_product_ids": [],
                      |      "entitled_variant_ids": [],
                      |      "entitled_collection_ids": [],
                      |      "entitled_country_ids": [],
                      |      "prerequisite_product_ids": [],
                      |      "prerequisite_variant_ids": [],
                      |      "customer_segment_prerequisite_ids": [],
                      |      "prerequisite_collection_ids": [],
                      |      "prerequisite_saved_search_ids": [],
                      |      "prerequisite_customer_ids": [],
                      |      "prerequisite_subtotal_range": null,
                      |      "prerequisite_quantity_range": null,
                      |      "prerequisite_shipping_price_range": null,
                      |      "prerequisite_to_entitlement_quantity_ratio": {
                      |        "prerequisite_quantity": null,
                      |        "entitled_quantity": null
                      |      },
                      |      "title": "SUMMERSALE10OFF",
                      |      "admin_graphql_api_id": "gid://shopify/PriceRule/507328175"
                      |    },
                      |    {
                      |      "id": 106886544,
                      |      "value_type": "fixed_amount",
                      |      "value": "-10.0",
                      |      "customer_selection": "all",
                      |      "target_type": "line_item",
                      |      "target_selection": "all",
                      |      "allocation_method": "across",
                      |      "allocation_limit": null,
                      |      "once_per_customer": false,
                      |      "usage_limit": null,
                      |      "starts_at": "2022-03-09T11:02:04-05:00",
                      |      "ends_at": "2022-03-13T11:02:04-04:00",
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "entitled_product_ids": [],
                      |      "entitled_variant_ids": [],
                      |      "entitled_collection_ids": [],
                      |      "entitled_country_ids": [],
                      |      "customer_segment_prerequisite_ids": [],
                      |      "prerequisite_product_ids": [],
                      |      "prerequisite_variant_ids": [],
                      |      "prerequisite_collection_ids": [],
                      |      "prerequisite_saved_search_ids": [],
                      |      "prerequisite_customer_ids": [],
                      |      "prerequisite_subtotal_range": null,
                      |      "prerequisite_quantity_range": null,
                      |      "prerequisite_shipping_price_range": null,
                      |      "prerequisite_to_entitlement_quantity_ratio": {
                      |        "prerequisite_quantity": null,
                      |        "entitled_quantity": null
                      |      },
                      |      "title": "TENOFF",
                      |      "admin_graphql_api_id": "gid://shopify/PriceRule/106886544"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        PriceRule(
          allocationMethod = "across",
          createdAt = "2022-03-11T11:02:04-05:00",
          updatedAt = "2022-03-11T11:02:04-05:00",
          customerSelection = "all",
          endsAt = "2022-03-17T11:02:04-04:00",
          entitledCollectionIds = List.empty,
          entitledCountryIds = List.empty,
          entitledProductIds = List.empty,
          entitledVariantIds = List.empty,
          id = Some(507328175),
          oncePerCustomer = Some(false),
          prerequisiteCustomerIds = List.empty,
          prerequisiteQuantityRange = None,
          customerSegmentPrerequisiteIds = List.empty,
          prerequisiteShippingPriceRange = None,
          prerequisiteSubtotalRange = None,
          prerequisiteToEntitlementPurchase = None,
          startsAt = "2022-03-05T11:02:04-05:00",
          targetSelection = "all",
          targetType = "line_item",
          title = "SUMMERSALE10OFF",
          usageLimit = None,
          prerequisiteProductIds = List.empty,
          prerequisiteVariantIds = List.empty,
          prerequisiteCollectionIds = List.empty,
          value = -10.0,
          valueType = "fixed_amount",
          prerequisiteToEntitlementQuantityRatio = Some(PrerequisiteToEntitlementQuantityRatio(None, None)),
          allocationLimit = None
        ),
        PriceRule(
          allocationMethod = "across",
          createdAt = "2022-03-11T11:02:04-05:00",
          updatedAt = "2022-03-11T11:02:04-05:00",
          customerSelection = "all",
          endsAt = "2022-03-13T11:02:04-04:00",
          entitledCollectionIds = List.empty,
          entitledCountryIds = List.empty,
          entitledProductIds = List.empty,
          entitledVariantIds = List.empty,
          id = Some(106886544),
          oncePerCustomer = Some(false),
          prerequisiteCustomerIds = List.empty,
          prerequisiteQuantityRange = None,
          customerSegmentPrerequisiteIds = List.empty,
          prerequisiteShippingPriceRange = None,
          prerequisiteSubtotalRange = None,
          prerequisiteToEntitlementPurchase = None,
          startsAt = "2022-03-09T11:02:04-05:00",
          targetSelection = "all",
          targetType = "line_item",
          title = "TENOFF",
          usageLimit = None,
          prerequisiteProductIds = List.empty,
          prerequisiteVariantIds = List.empty,
          prerequisiteCollectionIds = List.empty,
          value = -10.0,
          valueType = "fixed_amount",
          prerequisiteToEntitlementQuantityRatio = Some(PrerequisiteToEntitlementQuantityRatio(None, None)),
          allocationLimit = None
        )
      )
    )
  )

}
