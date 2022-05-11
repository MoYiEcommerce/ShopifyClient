package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.UpdateInventoryLevelByLocationId
import com.moyiecomm.shopify.api.inventory.models.{InventoryAdjustment, InventoryLevel}
import sttp.model.{Method, StatusCode}

class UpdateInventoryLevelByLocationIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateInventoryLevelByLocationId(
      InventoryAdjustment(
        availableAdjustment = Some(5),
        inventoryItemId = 808950810,
        locationId = 655441491
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/inventory_levels/adjust.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"location_id":655441491,"inventory_item_id":808950810,"available_adjustment":5}"""
    ),
    mapping = post("/admin/api/2022-01/inventory_levels/adjust.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"location_id":655441491,"inventory_item_id":808950810,"available_adjustment":5}"""
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
                      |    "available": 6,
                      |    "updated_at": "2022-04-05T12:52:29-04:00",
                      |    "admin_graphql_api_id": "gid://shopify/InventoryLevel/655441491?inventory_item_id=808950810"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      InventoryLevel(
        available = 6,
        inventoryItemId = 808950810,
        locationId = 655441491,
        updatedAt = "2022-04-05T12:52:29-04:00"
      )
    )
  )

}
