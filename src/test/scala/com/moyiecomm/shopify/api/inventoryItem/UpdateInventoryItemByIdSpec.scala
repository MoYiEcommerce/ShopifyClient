package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.WebHook
import com.moyiecomm.shopify.api.inventory.UpdateInventoryItemById
import com.moyiecomm.shopify.api.inventory.models.InventoryItem
import sttp.model.{Method, StatusCode}

class UpdateInventoryItemByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateInventoryItemById(
      InventoryItem(
        id = 808950810,
        sku = Some("new sku"),
        cost = None,
        countryCodeOfOrigin = None,
        countryHarmonizedSystemCodes = List.empty,
        harmonizedSystemCode = None,
        provinceCodeOfOrigin = None,
        tracked = None,
        requiresShipping = None,
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/inventory_items/808950810.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"inventory_item":{"id":808950810,"sku":"new sku"}}"""
    ),
    mapping = put("/admin/api/2022-01/inventory_items/808950810.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"inventory_item":{"id":808950810,"sku":"new sku"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "inventory_item": {
                      |    "id": 808950810,
                      |    "sku": "new sku",
                      |    "created_at": "2022-04-05T13:05:24-04:00",
                      |    "updated_at": "2022-04-05T13:17:13-04:00",
                      |    "requires_shipping": true,
                      |    "cost": "25.00",
                      |    "country_code_of_origin": null,
                      |    "province_code_of_origin": null,
                      |    "harmonized_system_code": null,
                      |    "tracked": true,
                      |    "country_harmonized_system_codes": [],
                      |    "admin_graphql_api_id": "gid://shopify/InventoryItem/808950810"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      InventoryItem(
        id = 808950810,
        sku = Some("new sku"),
        cost = Some(25.00),
        countryCodeOfOrigin = None,
        countryHarmonizedSystemCodes = List.empty,
        harmonizedSystemCode = None,
        provinceCodeOfOrigin = None,
        tracked = Some(true),
        requiresShipping = Some(true),
        createdAt = "2022-04-05T13:05:24-04:00",
        updatedAt = "2022-04-05T13:17:13-04:00"
      )
    )
  )

}
