package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price}
import sttp.model.{Method, StatusCode}

class CreateProductVariantSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateProductVariant(
      ProductVariant(
        id = None,
        productId = 632910392,
        option1 = Some("Yellow"),
        price = "1.00",
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
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/variants.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"variant":{"option1":"Yellow","price":"1.00","taxable":false}}"""),
    mapping = post("/admin/api/2022-01/products/632910392/variants.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"variant":{"option1":"Yellow","price":"1.00","taxable":false}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "variant": {
                      |    "id": 1070325032,
                      |    "product_id": 632910392,
                      |    "title": "Yellow",
                      |    "price": "1.00",
                      |    "sku": "",
                      |    "position": 5,
                      |    "inventory_policy": "deny",
                      |    "compare_at_price": null,
                      |    "fulfillment_service": "manual",
                      |    "inventory_management": "shopify",
                      |    "option1": "Yellow",
                      |    "option2": null,
                      |    "option3": null,
                      |    "created_at": "2022-03-11T11:05:47-05:00",
                      |    "updated_at": "2022-03-11T11:05:47-05:00",
                      |    "taxable": true,
                      |    "barcode": null,
                      |    "grams": 0,
                      |    "image_id": null,
                      |    "weight": 0,
                      |    "weight_unit": "lb",
                      |    "inventory_item_id": 1070325032,
                      |    "inventory_quantity": 0,
                      |    "old_inventory_quantity": 0,
                      |    "presentment_prices": [
                      |      {
                      |        "price": {
                      |          "amount": "1.00",
                      |          "currency_code": "USD"
                      |        },
                      |        "compare_at_price": null
                      |      }
                      |    ],
                      |    "requires_shipping": true,
                      |    "admin_graphql_api_id": "gid://shopify/ProductVariant/1070325032"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedResponseBody = Some(
      ProductVariant(
        id = Some(1070325032),
        productId = 632910392,
        price = "1.00",
        sku = Some(""),
        position = Some(5),
        inventoryPolicy = Some("deny"),
        compareAtPrice = None,
        fulfillmentService = Some("manual"),
        inventoryManagement = Some("shopify"),
        option1 = Some("Yellow"),
        option2 = None,
        option3 = None,
        createdAt = "2022-03-11T11:05:47-05:00",
        updatedAt = "2022-03-11T11:05:47-05:00",
        taxable = true,
        barcode = None,
        grams = Some(0),
        imageId = None,
        weight = Some(0),
        weightUnit = Some("lb"),
        inventoryItemId = Some(1070325032),
        inventoryQuantity = Some(0),
        presentmentPrices = List(
          PresentmentPrice(
            price = Price(
              amount = "1.00",
              currencyCode = "USD"
            ),
            compareAtPrice = None
          )
        ),
        taxCode = None
      )
    ),
    expectedStatusCode = StatusCode.Created
  )
}
