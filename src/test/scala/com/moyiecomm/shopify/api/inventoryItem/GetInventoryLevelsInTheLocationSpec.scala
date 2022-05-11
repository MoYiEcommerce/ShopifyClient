package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.{GetInventoryLevelsInTheLocation, GetInventoryLevelList}
import com.moyiecomm.shopify.api.inventory.models.InventoryLevel
import sttp.model.{Method, StatusCode}

class GetInventoryLevelsInTheLocationSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetInventoryLevelsInTheLocation(487838322),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/locations/487838322/inventory_levels.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/locations/487838322/inventory_levels.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "inventory_levels": [
                      |    {
                      |      "inventory_item_id": 808950810,
                      |      "location_id": 487838322,
                      |      "available": 9,
                      |      "updated_at": "2022-04-05T12:51:55-04:00",
                      |      "admin_graphql_api_id": "gid://shopify/InventoryLevel/548380009?inventory_item_id=808950810"
                      |    },
                      |    {
                      |      "inventory_item_id": 39072856,
                      |      "location_id": 487838322,
                      |      "available": 27,
                      |      "updated_at": "2022-04-05T12:51:55-04:00",
                      |      "admin_graphql_api_id": "gid://shopify/InventoryLevel/548380009?inventory_item_id=39072856"
                      |    },
                      |    {
                      |      "inventory_item_id": 808950810,
                      |      "location_id": 655441491,
                      |      "available": 1,
                      |      "updated_at": "2022-04-05T12:51:55-04:00",
                      |      "admin_graphql_api_id": "gid://shopify/InventoryLevel/655441491?inventory_item_id=808950810"
                      |    },
                      |    {
                      |      "inventory_item_id": 39072856,
                      |      "location_id": 655441491,
                      |      "available": 3,
                      |      "updated_at": "2022-04-05T12:51:55-04:00",
                      |      "admin_graphql_api_id": "gid://shopify/InventoryLevel/655441491?inventory_item_id=39072856"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        InventoryLevel(
          available = 9,
          inventoryItemId = 808950810,
          locationId = 487838322,
          updatedAt = "2022-04-05T12:51:55-04:00"
        ),
        InventoryLevel(
          available = 27,
          inventoryItemId = 39072856,
          locationId = 487838322,
          updatedAt = "2022-04-05T12:51:55-04:00"
        ),
        InventoryLevel(
          available = 1,
          inventoryItemId = 808950810,
          locationId = 655441491,
          updatedAt = "2022-04-05T12:51:55-04:00"
        ),
        InventoryLevel(
          available = 3,
          inventoryItemId = 39072856,
          locationId = 655441491,
          updatedAt = "2022-04-05T12:51:55-04:00"
        )
      )
    )
  )
}
