package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.Transaction
import com.moyiecomm.shopify.api.shared.models.{PaymentDetail, Receipt}
import sttp.model.{Method, StatusCode}

class GetTransactionListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetTransactionList(450789469),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/transactions.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders/450789469/transactions.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "transactions": [
                      |    {
                      |      "id": 179259969,
                      |      "order_id": 450789469,
                      |      "kind": "refund",
                      |      "gateway": "bogus",
                      |      "status": "success",
                      |      "message": null,
                      |      "created_at": "2005-08-05T12:59:12-04:00",
                      |      "test": false,
                      |      "authorization": "authorization-key",
                      |      "location_id": null,
                      |      "user_id": null,
                      |      "parent_id": 801038806,
                      |      "processed_at": "2005-08-05T12:59:12-04:00",
                      |      "device_id": null,
                      |      "error_code": null,
                      |      "source_name": "web",
                      |      "receipt": {},
                      |      "currency_exchange_adjustment": null,
                      |      "amount": "209.00",
                      |      "currency": "USD",
                      |      "admin_graphql_api_id": "gid://shopify/OrderTransaction/179259969"
                      |    },
                      |    {
                      |      "id": 389404469,
                      |      "order_id": 450789469,
                      |      "kind": "authorization",
                      |      "gateway": "bogus",
                      |      "status": "success",
                      |      "message": null,
                      |      "created_at": "2005-08-01T11:57:11-04:00",
                      |      "test": false,
                      |      "authorization": "authorization-key",
                      |      "location_id": null,
                      |      "user_id": null,
                      |      "parent_id": null,
                      |      "processed_at": "2005-08-01T11:57:11-04:00",
                      |      "device_id": null,
                      |      "error_code": null,
                      |      "source_name": "web",
                      |      "payment_details": {
                      |        "credit_card_bin": null,
                      |        "avs_result_code": null,
                      |        "cvv_result_code": null,
                      |        "credit_card_number": "•••• •••• •••• 4242",
                      |        "credit_card_company": "Visa",
                      |        "credit_card_name": null,
                      |        "credit_card_wallet": null,
                      |        "credit_card_expiration_month": null,
                      |        "credit_card_expiration_year": null
                      |      },
                      |      "receipt": {
                      |        "testcase": true,
                      |        "authorization": "123456"
                      |      },
                      |      "currency_exchange_adjustment": null,
                      |      "amount": "598.94",
                      |      "currency": "USD",
                      |      "admin_graphql_api_id": "gid://shopify/OrderTransaction/389404469"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Transaction(
          id = Some(179259969),
          orderId = Some(450789469),
          kind = Some("refund"),
          gateway = Some("bogus"),
          status = Some("success"),
          message = None,
          createdAt = "2005-08-05T12:59:12-04:00",
          test = Some(false),
          authorization = Some("authorization-key"),
          locationId = None,
          userId = None,
          parentId = Some(801038806),
          processedAt = "2005-08-05T12:59:12-04:00",
          sourceName = Some("web"),
          paymentDetails = None,
          currencyExchangeAdjustment = None,
          amount = Some("209.00"),
          paymentsRefundAttributes = None,
          currency = Some("USD"),
          authorizationExpiresAt = None,
          deviceId = None,
          errorCode = None,
          extendedAuthorizationAttributes = None
        ),
        Transaction(
          id = Some(389404469),
          orderId = Some(450789469),
          kind = Some("authorization"),
          gateway = Some("bogus"),
          status = Some("success"),
          message = None,
          createdAt = "2005-08-01T11:57:11-04:00",
          test = Some(false),
          authorization = Some("authorization-key"),
          locationId = None,
          userId = None,
          parentId = None,
          processedAt = "2005-08-01T11:57:11-04:00",
          sourceName = Some("web"),
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
          amount = Some("598.94"),
          paymentsRefundAttributes = None,
          currency = Some("USD"),
          authorizationExpiresAt = None,
          deviceId = None,
          errorCode = None,
          extendedAuthorizationAttributes = None
        )
      )
    )
  )

}
