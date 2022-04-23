package com.moyiecomm.shopify.api.analytics

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.analytics.models.Report
import sttp.model.{Method, StatusCode}

class GetReportByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetReportById(517154478),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/reports/517154478.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/reports/517154478.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "report": {
              |    "id": 517154478,
              |    "name": "Wholesale Sales Report",
              |    "shopify_ql": "SHOW total_sales BY order_id FROM sales WHERE api_client_id == 123 SINCE -1m UNTIL today",
              |    "updated_at": "2017-04-10T16:33:22-04:00",
              |    "category": "custom_app_reports"
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Report(
        id = Some(517154478),
        category = Some("custom_app_reports"),
        name = "Wholesale Sales Report",
        shopifyQl = "SHOW total_sales BY order_id FROM sales WHERE api_client_id == 123 SINCE -1m UNTIL today",
        updatedAt = "2017-04-10T16:33:22-04:00"
      )
    )
  )

}
