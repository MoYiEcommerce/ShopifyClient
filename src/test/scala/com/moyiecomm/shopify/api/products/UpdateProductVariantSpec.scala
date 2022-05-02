package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.ProductVariant
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price}

class UpdateProductVariantSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateProductVariant(
      ProductVariant(
        id = Some(808950810),
        productId = 632910392,
        option1 = Some("Not Pink"),
        price = "99.00",
        barcode = None,
        compareAtPrice = None,
        createdAt = None,
        fulfillmentService = None,
        grams = None,
        imageId = None,
        inventoryItemId = None,
        inventoryManagement = None,
        inventoryPolicy = None,
        inventoryQuantity = None,
        option2 = None,
        option3 = None,
        presentmentPrices = List.empty,
        position = None,
        sku = None,
        taxable = false,
        taxCode = None,
        updatedAt = None,
        weight = None,
        weightUnit = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/variants/808950810.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some("""{"variant":{"id":808950810,"option1":"Not Pink","price":"99.00","taxable":false}}"""),
    mapping = put("/admin/api/2022-01/variants/808950810.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson("""{"variant":{"id":808950810,"option1":"Not Pink","price":"99.00","taxable":false}}""")
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "variant": {
                      |    "option1": "Not Pink",
                      |    "price": "99.00",
                      |    "id": 808950810,
                      |    "product_id": 632910392,
                      |    "title": "Not Pink",
                      |    "sku": "IPOD2008PINK",
                      |    "position": 1,
                      |    "inventory_policy": "continue",
                      |    "compare_at_price": null,
                      |    "fulfillment_service": "manual",
                      |    "inventory_management": "shopify",
                      |    "option2": null,
                      |    "option3": null,
                      |    "created_at": "2022-03-11T11:02:04-05:00",
                      |    "updated_at": "2022-03-11T11:05:21-05:00",
                      |    "taxable": true,
                      |    "barcode": "1234_pink",
                      |    "grams": 567,
                      |    "image_id": 562641783,
                      |    "weight": 1.25,
                      |    "weight_unit": "lb",
                      |    "inventory_item_id": 808950810,
                      |    "inventory_quantity": 10,
                      |    "old_inventory_quantity": 10,
                      |    "presentment_prices": [
                      |      {
                      |        "price": {
                      |          "amount": "99.00",
                      |          "currency_code": "USD"
                      |        },
                      |        "compare_at_price": null
                      |      }
                      |    ],
                      |    "requires_shipping": true,
                      |    "admin_graphql_api_id": "gid://shopify/ProductVariant/808950810"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      ProductVariant(
        id = Some(808950810),
        productId = 632910392,
        option1 = Some("Not Pink"),
        price = "99.00",
        barcode = Some("1234_pink"),
        compareAtPrice = None,
        createdAt = "2022-03-11T11:02:04-05:00",
        fulfillmentService = Some("manual"),
        grams = Some(567),
        imageId = Some(562641783),
        inventoryItemId = Some(808950810),
        inventoryManagement = Some("shopify"),
        inventoryPolicy = Some("continue"),
        inventoryQuantity = Some(10),
        option2 = None,
        option3 = None,
        presentmentPrices = List(
          PresentmentPrice(
            price = Price(amount = "99.00", currencyCode = "USD"),
            compareAtPrice = None
          )
        ),
        position = Some(1),
        sku = Some("IPOD2008PINK"),
        taxable = true,
        taxCode = None,
        updatedAt = "2022-03-11T11:05:21-05:00",
        weight = Some(1.25),
        weightUnit = Some("lb")
      )
    )
  )

}
