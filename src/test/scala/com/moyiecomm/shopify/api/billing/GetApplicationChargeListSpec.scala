package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.ApplicationCharge
import com.moyiecomm.shopify.api.shared.models.Accepted
import sttp.model.{Method, StatusCode}

class GetApplicationChargeListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetApplicationChargeList(None),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/application_charges.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/application_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "application_charges": [
                      |    {
                      |      "id": 1017262346,
                      |      "name": "Create me a logo",
                      |      "api_client_id": 755357713,
                      |      "price": "120.00",
                      |      "status": "accepted",
                      |      "return_url": "http://google.com",
                      |      "test": null,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "charge_type": "brokered_service",
                      |      "decorated_return_url": "http://google.com?charge_id=1017262346"
                      |    },
                      |    {
                      |      "id": 556467234,
                      |      "name": "Green theme",
                      |      "api_client_id": 755357713,
                      |      "price": "120.00",
                      |      "status": "accepted",
                      |      "return_url": "http://google.com",
                      |      "test": null,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "charge_type": "theme",
                      |      "decorated_return_url": "http://google.com?charge_id=556467234"
                      |    },
                      |    {
                      |      "id": 675931192,
                      |      "name": "iPod Cleaning",
                      |      "api_client_id": 755357713,
                      |      "price": "5.00",
                      |      "status": "accepted",
                      |      "return_url": "http://google.com",
                      |      "test": null,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "charge_type": null,
                      |      "decorated_return_url": "http://google.com?charge_id=675931192"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        ApplicationCharge(
          confirmationUrl = None,
          createdAt = "2022-04-05T13:05:24-04:00",
          id = Some(1017262346),
          apiClientId = Some(755357713),
          name = "Create me a logo",
          price = 120.00,
          returnUrl = Some("http://google.com"),
          status = Some(Accepted),
          chargeType = Some("brokered_service"),
          decoratedReturnUrl = Some("http://google.com?charge_id=1017262346"),
          test = None,
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        ApplicationCharge(
          confirmationUrl = None,
          createdAt = "2022-04-05T13:05:24-04:00",
          id = Some(556467234),
          apiClientId = Some(755357713),
          name = "Green theme",
          price = 120.00,
          returnUrl = Some("http://google.com"),
          status = Some(Accepted),
          chargeType = Some("theme"),
          decoratedReturnUrl = Some("http://google.com?charge_id=556467234"),
          test = None,
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        ApplicationCharge(
          confirmationUrl = None,
          createdAt = "2022-04-05T13:05:24-04:00",
          id = Some(675931192),
          apiClientId = Some(755357713),
          name = "iPod Cleaning",
          price = 5.00,
          returnUrl = Some("http://google.com"),
          status = Some(Accepted),
          chargeType = None,
          decoratedReturnUrl = Some("http://google.com?charge_id=675931192"),
          test = None,
          updatedAt = "2022-04-05T13:05:24-04:00"
        )
      )
    )
  )

}
