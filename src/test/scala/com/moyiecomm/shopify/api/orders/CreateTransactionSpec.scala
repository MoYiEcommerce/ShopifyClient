package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, equalToJson, post}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.{OrderRisk, Transaction}
import com.moyiecomm.shopify.api.shared.models.PaymentDetail
import sttp.model.{Method, StatusCode}

class CreateTransactionSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateTransaction(
      Transaction(
        id = None,
        orderId = Some(450789469),
        kind = Some("capture"),
        gateway = None,
        status = None,
        message = None,
        createdAt = None,
        test = None,
        authorization = None,
        locationId = None,
        userId = None,
        parentId = Some(389404469),
        processedAt = None,
        sourceName = None,
        paymentDetails = None,
        currencyExchangeAdjustment = None,
        amount = Some("10.00"),
        paymentsRefundAttributes = None,
        currency = Some("USD"),
        authorizationExpiresAt = None,
        deviceId = None,
        errorCode = None,
        extendedAuthorizationAttributes = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/transactions.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"transaction":{"currency":"USD","amount":"10.00","kind":"capture","parent_id":389404469}}"""
    ),
    mapping = post("/admin/api/2022-01/orders/450789469/transactions.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"transaction":{"currency":"USD","amount":"10.00","kind":"capture","parent_id":389404469}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "transaction": {
              |    "id": 1068278470,
              |    "order_id": 450789469,
              |    "kind": "capture",
              |    "gateway": "bogus",
              |    "status": "success",
              |    "message": "Bogus Gateway: Forced success",
              |    "created_at": "2022-04-05T13:06:22-04:00",
              |    "test": true,
              |    "authorization": null,
              |    "location_id": null,
              |    "user_id": null,
              |    "parent_id": 389404469,
              |    "processed_at": "2022-04-05T13:06:22-04:00",
              |    "device_id": null,
              |    "error_code": null,
              |    "source_name": "755357713",
              |    "payment_details": {
              |      "credit_card_bin": null,
              |      "avs_result_code": null,
              |      "cvv_result_code": null,
              |      "credit_card_number": "•••• •••• •••• 4242",
              |      "credit_card_company": "Visa",
              |      "credit_card_name": null,
              |      "credit_card_wallet": null,
              |      "credit_card_expiration_month": null,
              |      "credit_card_expiration_year": null
              |    },
              |    "receipt": null,
              |    "currency_exchange_adjustment": null,
              |    "amount": "10.00",
              |    "currency": "USD",
              |    "admin_graphql_api_id": "gid://shopify/OrderTransaction/1068278470"
              |  }
              |}
              |""".stripMargin // todo handle receipt is {}
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Transaction(
        id = Some(1068278470),
        orderId = Some(450789469),
        kind = Some("capture"),
        gateway = Some("bogus"),
        status = Some("success"),
        message = Some("Bogus Gateway: Forced success"),
        createdAt = "2022-04-05T13:06:22-04:00",
        test = Some(true),
        authorization = None,
        locationId = None,
        userId = None,
        parentId = Some(389404469),
        processedAt = "2022-04-05T13:06:22-04:00",
        sourceName = Some("755357713"),
        paymentDetails = Some(
          PaymentDetail(
            creditCardBin = None,
            avsResultCode = None,
            cvvResultCode = None,
            creditCardNumber = "•••• •••• •••• 4242",
            creditCardCompany = "Visa"
          )
        ),
        currencyExchangeAdjustment = None,
        amount = Some("10.00"),
        paymentsRefundAttributes = None,
        currency = Some("USD"),
        authorizationExpiresAt = None,
        deviceId = None,
        errorCode = None,
        extendedAuthorizationAttributes = None
      )
    )
  )
}
