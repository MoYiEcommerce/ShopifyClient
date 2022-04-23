package com.moyiecomm.shopify.api.analytics

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.analytics.models.Report
import sttp.model.{Method, StatusCode}

class GetReportListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetReportList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/reports.json",
    expectedRequestBody = None,
    expectedMethod = Method.GET,
    mapping = get("/admin/api/2022-01/reports.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "reports": [
              |    {
              |      "id": 752357116,
              |      "name": "Custom App Report 2",
              |      "shopify_ql": "SHOW total_sales BY order_id FROM sales ORDER BY total_sales",
              |      "updated_at": "2022-04-05T13:05:24-04:00",
              |      "category": "custom_app_reports"
              |    },
              |    {
              |      "id": 517154478,
              |      "name": "Wholesale Sales Report",
              |      "shopify_ql": "SHOW total_sales BY order_id FROM sales WHERE api_client_id == 123 SINCE -1m UNTIL today",
              |      "updated_at": "2017-04-10T16:33:22-04:00",
              |      "category": "custom_app_reports"
              |    }
              |  ]
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Report(
          id = Some(752357116),
          category = Some("custom_app_reports"),
          name = "Custom App Report 2",
          shopifyQl = "SHOW total_sales BY order_id FROM sales ORDER BY total_sales",
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        Report(
          id = Some(517154478),
          category = Some("custom_app_reports"),
          name = "Wholesale Sales Report",
          shopifyQl = "SHOW total_sales BY order_id FROM sales WHERE api_client_id == 123 SINCE -1m UNTIL today",
          updatedAt = "2017-04-10T16:33:22-04:00"
        )
      )
    )
  )

}
