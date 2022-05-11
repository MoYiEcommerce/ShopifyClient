package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.DeleteInventoryLevel
import sttp.model.{Method, StatusCode}

class DeleteInventoryLevel extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteInventoryLevel(808950810, 655441491),
    expectedUrl =
      s"http://localhost:$port/admin/api/2022-01/inventory_levels.json?inventory_item_id=808950810&location_id=655441491",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/inventory_levels.json?inventory_item_id=808950810&location_id=655441491")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(204)
      ),
    expectedStatusCode = StatusCode.NoContent,
    expectedResponseBody = None
  )

}
