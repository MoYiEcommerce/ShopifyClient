package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.GetInventoryItemList
import com.moyiecomm.shopify.api.inventory.models.InventoryItem
import sttp.model.{Method, StatusCode}

class GetInventoryItemListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetInventoryItemList(List(808950810, 39072856, 457924702)),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/inventory_items.json?ids=808950810,39072856,457924702",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/inventory_items.json?ids=808950810,39072856,457924702")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "inventory_items": [
                      |    {
                      |      "id": 39072856,
                      |      "sku": "IPOD2008GREEN",
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "requires_shipping": true,
                      |      "cost": "25.00",
                      |      "country_code_of_origin": null,
                      |      "province_code_of_origin": null,
                      |      "harmonized_system_code": null,
                      |      "tracked": true,
                      |      "country_harmonized_system_codes": [],
                      |      "admin_graphql_api_id": "gid://shopify/InventoryItem/39072856"
                      |    },
                      |    {
                      |      "id": 457924702,
                      |      "sku": "IPOD2008BLACK",
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "requires_shipping": true,
                      |      "cost": "25.00",
                      |      "country_code_of_origin": null,
                      |      "province_code_of_origin": null,
                      |      "harmonized_system_code": null,
                      |      "tracked": true,
                      |      "country_harmonized_system_codes": [],
                      |      "admin_graphql_api_id": "gid://shopify/InventoryItem/457924702"
                      |    },
                      |    {
                      |      "id": 808950810,
                      |      "sku": "IPOD2008PINK",
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "requires_shipping": true,
                      |      "cost": "25.00",
                      |      "country_code_of_origin": null,
                      |      "province_code_of_origin": null,
                      |      "harmonized_system_code": null,
                      |      "tracked": true,
                      |      "country_harmonized_system_codes": [],
                      |      "admin_graphql_api_id": "gid://shopify/InventoryItem/808950810"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        InventoryItem(
          id = 39072856,
          sku = Some("IPOD2008GREEN"),
          cost = Some(25.00),
          countryCodeOfOrigin = None,
          countryHarmonizedSystemCodes = List.empty,
          harmonizedSystemCode = None,
          provinceCodeOfOrigin = None,
          tracked = Some(true),
          requiresShipping = Some(true),
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        InventoryItem(
          id = 457924702,
          sku = Some("IPOD2008BLACK"),
          cost = Some(25.00),
          countryCodeOfOrigin = None,
          countryHarmonizedSystemCodes = List.empty,
          harmonizedSystemCode = None,
          provinceCodeOfOrigin = None,
          tracked = Some(true),
          requiresShipping = Some(true),
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        InventoryItem(
          id = 808950810,
          sku = Some("IPOD2008PINK"),
          cost = Some(25.00),
          countryCodeOfOrigin = None,
          countryHarmonizedSystemCodes = List.empty,
          harmonizedSystemCode = None,
          provinceCodeOfOrigin = None,
          tracked = Some(true),
          requiresShipping = Some(true),
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00"
        )
      )
    )
  )

}
