package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.PriceRule
import com.moyiecomm.shopify.api.shared.models.Conditions.{PrerequisiteAmount, PrerequisiteToEntitlementQuantityRatio}
import sttp.model.{Method, StatusCode}

class CreatePriceRuleSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreatePriceRule(
      PriceRule(
        allocationMethod = "across",
        createdAt = None,
        updatedAt = None,
        customerSelection = "all",
        endsAt = None,
        entitledCollectionIds = List.empty,
        entitledCountryIds = List.empty,
        entitledProductIds = List.empty,
        entitledVariantIds = List.empty,
        id = None,
        oncePerCustomer = None,
        prerequisiteCustomerIds = List.empty,
        prerequisiteQuantityRange = None,
        customerSegmentPrerequisiteIds = List.empty,
        prerequisiteShippingPriceRange = None,
        prerequisiteSubtotalRange = None,
        prerequisiteToEntitlementPurchase = None,
        startsAt = "2017-01-19T17:59:10Z",
        targetSelection = "all",
        targetType = "line_item",
        title = "SUMMERSALE10OFF",
        usageLimit = None,
        prerequisiteProductIds = List.empty,
        prerequisiteVariantIds = List.empty,
        prerequisiteCollectionIds = List.empty,
        value = -10.0,
        valueType = "fixed_amount",
        prerequisiteToEntitlementQuantityRatio = None,
        allocationLimit = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"price_rule":{"title":"SUMMERSALE10OFF","target_type":"line_item","target_selection":"all","allocation_method":"across","value_type":"fixed_amount","value":"-10.0","customer_selection":"all","starts_at":"2017-01-19T17:59:10Z"}}"""
    ),
    mapping = post("/admin/api/2022-01/price_rules.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"price_rule":{"title":"SUMMERSALE10OFF","target_type":"line_item","target_selection":"all","allocation_method":"across","value_type":"fixed_amount","value":"-10.0","customer_selection":"all","starts_at":"2017-01-19T17:59:10Z"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "price_rule": {
                      |    "id": 996341478,
                      |    "value_type": "fixed_amount",
                      |    "value": "-10.0",
                      |    "customer_selection": "all",
                      |    "target_type": "line_item",
                      |    "target_selection": "all",
                      |    "allocation_method": "across",
                      |    "allocation_limit": null,
                      |    "once_per_customer": false,
                      |    "usage_limit": null,
                      |    "starts_at": "2017-01-19T12:59:10-05:00",
                      |    "ends_at": null,
                      |    "created_at": "2022-03-11T11:11:26-05:00",
                      |    "updated_at": "2022-03-11T11:11:26-05:00",
                      |    "entitled_product_ids": [],
                      |    "entitled_variant_ids": [],
                      |    "entitled_collection_ids": [],
                      |    "entitled_country_ids": [],
                      |    "prerequisite_product_ids": [],
                      |    "prerequisite_variant_ids": [],
                      |    "prerequisite_collection_ids": [],
                      |    "customer_segment_prerequisite_ids": [],
                      |    "prerequisite_customer_ids": [],
                      |    "prerequisite_subtotal_range": null,
                      |    "prerequisite_quantity_range": null,
                      |    "prerequisite_shipping_price_range": null,
                      |    "prerequisite_to_entitlement_quantity_ratio": {
                      |      "prerequisite_quantity": null,
                      |      "entitled_quantity": null
                      |    },
                      |    "prerequisite_to_entitlement_purchase": {
                      |      "prerequisite_amount": null
                      |    },
                      |    "title": "SUMMERSALE10OFF",
                      |    "admin_graphql_api_id": "gid://shopify/PriceRule/996341478"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      PriceRule(
        allocationMethod = "across",
        createdAt = "2022-03-11T11:11:26-05:00",
        updatedAt = "2022-03-11T11:11:26-05:00",
        customerSelection = "all",
        endsAt = None,
        entitledCollectionIds = List.empty,
        entitledCountryIds = List.empty,
        entitledProductIds = List.empty,
        entitledVariantIds = List.empty,
        id = Some(996341478),
        oncePerCustomer = Some(false),
        prerequisiteCustomerIds = List.empty,
        prerequisiteQuantityRange = None,
        customerSegmentPrerequisiteIds = List.empty,
        prerequisiteShippingPriceRange = None,
        prerequisiteSubtotalRange = None,
        prerequisiteToEntitlementPurchase = Some(PrerequisiteAmount(None)),
        startsAt = "2017-01-19T12:59:10-05:00",
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
      )
    )
  )
}
