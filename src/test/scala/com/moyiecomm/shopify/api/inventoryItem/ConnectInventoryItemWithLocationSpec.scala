package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.ConnectInventoryItemWithLocation
import com.moyiecomm.shopify.api.inventory.models.{InventoryAdjustment, InventoryLevel}
import sttp.model.{Method, StatusCode}

class ConnectInventoryItemWithLocationSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = ConnectInventoryItemWithLocation(
      InventoryAdjustment(
        availableAdjustment = None,
        inventoryItemId = 457924702,
        locationId = 844681632
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/inventory_levels/connect.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"location_id":844681632,"inventory_item_id":457924702}"""
    ),
    mapping = post("/admin/api/2022-01/inventory_levels/connect.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"location_id":844681632,"inventory_item_id":457924702}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "inventory_level": {
                      |    "inventory_item_id": 457924702,
                      |    "location_id": 844681632,
                      |    "available": 0,
                      |    "updated_at": "2022-04-05T12:52:36-04:00",
                      |    "admin_graphql_api_id": "gid://shopify/InventoryLevel/844681632?inventory_item_id=457924702"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      InventoryLevel(
        available = 0,
        inventoryItemId = 457924702,
        locationId = 844681632,
        updatedAt = "2022-04-05T12:52:36-04:00"
      )
    )
  )

}
