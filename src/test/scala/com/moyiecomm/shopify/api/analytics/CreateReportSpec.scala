package com.moyiecomm.shopify.api.analytics

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.analytics.models.Report
import sttp.model.{Method, StatusCode}

class CreateReportSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateReport(
      Report(
        id = None,
        category = None,
        name = "A new app report",
        shopifyQl = "SHOW total_sales BY order_id FROM sales SINCE -1m UNTIL today ORDER BY total_sales",
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/reports.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"report":{"name":"A new app report","shopify_ql":"SHOW total_sales BY order_id FROM sales SINCE -1m UNTIL today ORDER BY total_sales"}}"""
    ),
    mapping = post("/admin/api/2022-01/reports.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"report":{"name":"A new app report","shopify_ql":"SHOW total_sales BY order_id FROM sales SINCE -1m UNTIL today ORDER BY total_sales"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "report": {
                      |    "id": 1016888664,
                      |    "name": "A new app report",
                      |    "shopify_ql": "SHOW total_sales BY order_id FROM sales SINCE -1m UNTIL today ORDER BY total_sales",
                      |    "updated_at": "2022-04-05T13:05:35-04:00",
                      |    "category": "custom_app_reports"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Report(
        id = Some(1016888664),
        category = Some("custom_app_reports"),
        name = "A new app report",
        shopifyQl = "SHOW total_sales BY order_id FROM sales SINCE -1m UNTIL today ORDER BY total_sales",
        updatedAt = "2022-04-05T13:05:35-04:00"
      )
    )
  )

}
