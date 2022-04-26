package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, post}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.CustomerInvite
import sttp.model.{Method, StatusCode}

class SendAccountInvitationSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = SendAccountInvitation(207119551),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/send_invite.json",
    expectedMethod = Method.POST,
    expectedRequestBody = None,
    mapping = post("/admin/api/2022-01/customers/207119551/send_invite.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "customer_invite": {
                      |    "to": "bob.norman@mail.example.com",
                      |    "from": "j.smith@example.com",
                      |    "subject": "Customer account activation",
                      |    "custom_message": "",
                      |    "bcc": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      CustomerInvite(
        to = "bob.norman@mail.example.com",
        from = "j.smith@example.com",
        subject = "Customer account activation",
        customMessage = Some(""),
        bcc = List.empty
      )
    )
  )
}
