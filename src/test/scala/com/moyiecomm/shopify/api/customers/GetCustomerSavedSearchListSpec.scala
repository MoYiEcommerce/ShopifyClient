package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch
import sttp.model.{Method, StatusCode}

class GetCustomerSavedSearchListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCustomerSavedSearchList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customer_saved_searches.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/customer_saved_searches.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer_saved_searches": [
                      |    {
                      |      "id": 789629109,
                      |      "name": "Accepts Marketing",
                      |      "created_at": "2022-03-04T10:52:46-05:00",
                      |      "updated_at": "2022-03-04T10:52:46-05:00",
                      |      "query": "accepts_marketing:1"
                      |    },
                      |    {
                      |      "id": 20610973,
                      |      "name": "Canadian Snowboarders",
                      |      "created_at": "2022-03-04T10:52:46-05:00",
                      |      "updated_at": "2022-03-04T10:52:46-05:00",
                      |      "query": "country:Canada"
                      |    },
                      |    {
                      |      "id": 669439218,
                      |      "name": "Premier Customers",
                      |      "created_at": "2022-03-04T10:52:46-05:00",
                      |      "updated_at": "2022-03-04T10:52:46-05:00",
                      |      "query": "John Smith orders_count:>10 total_spent:>100.00"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        CustomerSavedSearch(
          id = Some(789629109),
          name = "Accepts Marketing",
          query = "accepts_marketing:1",
          createdAt = "2022-03-04T10:52:46-05:00",
          updatedAt = "2022-03-04T10:52:46-05:00"
        ),
        CustomerSavedSearch(
          id = Some(20610973),
          name = "Canadian Snowboarders",
          query = "country:Canada",
          createdAt = "2022-03-04T10:52:46-05:00",
          updatedAt = "2022-03-04T10:52:46-05:00"
        ),
        CustomerSavedSearch(
          id = Some(669439218),
          name = "Premier Customers",
          query = "John Smith orders_count:>10 total_spent:>100.00",
          createdAt = "2022-03-04T10:52:46-05:00",
          updatedAt = "2022-03-04T10:52:46-05:00"
        )
      )
    )
  )

}
