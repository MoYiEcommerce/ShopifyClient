package com.moyiecomm.shopify.api.analytics

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.analytics.models.Report
import sttp.model.{Method, StatusCode}

class UpdateReportByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateReportById(
      Report(
        id = Some(517154478),
        category = None,
        name = "Changed Report Name",
        shopifyQl = "SHOW total_sales BY order_id FROM sales SINCE -12m UNTIL today ORDER BY total_sales",
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/reports/517154478.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"report":{"id":517154478,"name":"Changed Report Name","shopify_ql":"SHOW total_sales BY order_id FROM sales SINCE -12m UNTIL today ORDER BY total_sales"}}"""
    ),
    mapping = put("/admin/api/2022-01/reports/517154478.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"report":{"id":517154478,"name":"Changed Report Name","shopify_ql":"SHOW total_sales BY order_id FROM sales SINCE -12m UNTIL today ORDER BY total_sales"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "report": {
                      |    "name": "Changed Report Name",
                      |    "shopify_ql": "SHOW total_sales BY order_id FROM sales SINCE -12m UNTIL today ORDER BY total_sales",
                      |    "id": 517154478,
                      |    "updated_at": "2022-04-05T13:05:37-04:00",
                      |    "category": "custom_app_reports"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Report(
        id = Some(517154478),
        category = Some("custom_app_reports"),
        name = "Changed Report Name",
        shopifyQl = "SHOW total_sales BY order_id FROM sales SINCE -12m UNTIL today ORDER BY total_sales",
        updatedAt = "2022-04-05T13:05:37-04:00"
      )
    )
  )

}
