package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.DraftOrderInvoice
import sttp.model.{Method, StatusCode}

class SendDraftOrderInvoiceSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = SendDraftOrderInvoice(
      994118539,
      DraftOrderInvoice(
        to = "first@example.com",
        from = "j.smith@example.com",
        bcc = List("j.smith@example.com"),
        subject = "Apple Computer Invoice",
        customMessage = "Thank you for ordering!"
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/draft_orders/994118539/send_invoice.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"draft_order_invoice":{"to":"first@example.com","from":"j.smith@example.com","bcc":["j.smith@example.com"],"subject":"Apple Computer Invoice","custom_message":"Thank you for ordering!"}}"""
    ),
    mapping = post("/admin/api/2022-01/draft_orders/994118539/send_invoice.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"draft_order_invoice":{"to":"first@example.com","from":"j.smith@example.com","bcc":["j.smith@example.com"],"subject":"Apple Computer Invoice","custom_message":"Thank you for ordering!"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "draft_order_invoice": {
              |    "to": "first@example.com",
              |    "from": "j.smith@example.com",
              |    "subject": "Apple Computer Invoice",
              |    "custom_message": "Thank you for ordering!",
              |    "bcc": [
              |      "j.smith@example.com"
              |    ]
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      DraftOrderInvoice(
        to = "first@example.com",
        from = "j.smith@example.com",
        bcc = List("j.smith@example.com"),
        subject = "Apple Computer Invoice",
        customMessage = "Thank you for ordering!"
      )
    )
  )

}
