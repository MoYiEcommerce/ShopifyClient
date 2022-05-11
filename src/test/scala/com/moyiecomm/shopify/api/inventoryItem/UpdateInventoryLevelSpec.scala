package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.UpdateInventoryLevel
import com.moyiecomm.shopify.api.inventory.models.{InventoryAdjustment, InventoryLevel}
import sttp.model.{Method, StatusCode}

class UpdateInventoryLevelSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateInventoryLevel(
      InventoryLevel(
        available = 42,
        inventoryItemId = 808950810,
        locationId = 655441491,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/inventory_levels/set.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"location_id":655441491,"inventory_item_id":808950810,"available":42}"""
    ),
    mapping = post("/admin/api/2022-01/inventory_levels/set.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"location_id":655441491,"inventory_item_id":808950810,"available":42}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "inventory_level": {
                      |    "inventory_item_id": 808950810,
                      |    "location_id": 655441491,
                      |    "available": 42,
                      |    "updated_at": "2022-04-05T12:52:40-04:00",
                      |    "admin_graphql_api_id": "gid://shopify/InventoryLevel/655441491?inventory_item_id=808950810"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      InventoryLevel(
        available = 42,
        inventoryItemId = 808950810,
        locationId = 655441491,
        updatedAt = "2022-04-05T12:52:40-04:00"
      )
    )
  )

}
