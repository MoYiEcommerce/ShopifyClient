package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.{Product, ProductVariant}
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price, ProductOption}

class UpdateProductByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateProductById(
      Product(
        Some(632910392),
        "testProduct",
        Some("<strong>Good snowboard!</strong>"),
        None,
        Some("testVendor"),
        List.empty,
        options = List.empty,
        "testProductType",
        None,
        None,
        None,
        None,
        List.empty,
        None,
        None,
        None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"product":{"id":632910392,"title":"testProduct","body_html":"\u003cstrong\u003eGood snowboard!\u003c/strong\u003e","vendor":"testVendor","product_type":"testProductType"}}"""
    ),
    mapping = put("/admin/api/2022-01/products/632910392.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"product":{"id":632910392,"title":"testProduct","body_html":"\u003cstrong\u003eGood snowboard!\u003c/strong\u003e","vendor":"testVendor","product_type":"testProductType"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      {
                      |  "product": {
                      |    "id": 632910392,
                      |    "title": "Burton Custom Freestyle 151",
                      |    "body_html": "<strong>Good snowboard!</strong>",
                      |    "vendor": "Burton",
                      |    "product_type": "Snowboard",
                      |    "created_at": "2022-02-03T17:19:42-05:00",
                      |    "handle": "burton-custom-freestyle-151",
                      |    "updated_at": "2022-02-03T17:19:42-05:00",
                      |    "published_at": "2022-02-03T17:19:42-05:00",
                      |    "template_suffix": null,
                      |    "status": "active",
                      |    "published_scope": "web",
                      |    "tags": "Barnes & Noble, Big Air, John's Fav",
                      |    "admin_graphql_api_id": "gid://shopify/Product/1071559625",
                      |    "variants": [
                      |      {
                      |        "id": 1070325095,
                      |        "product_id": 1071559625,
                      |        "title": "Default Title",
                      |        "price": "0.00",
                      |        "sku": "",
                      |        "position": 1,
                      |        "inventory_policy": "deny",
                      |        "compare_at_price": null,
                      |        "fulfillment_service": "manual",
                      |        "inventory_management": null,
                      |        "option1": "Default Title",
                      |        "option2": null,
                      |        "option3": null,
                      |        "created_at": "2022-02-03T17:19:42-05:00",
                      |        "updated_at": "2022-02-03T17:19:42-05:00",
                      |        "taxable": true,
                      |        "barcode": null,
                      |        "grams": 0,
                      |        "image_id": null,
                      |        "weight": 0,
                      |        "weight_unit": "lb",
                      |        "inventory_item_id": 1070325095,
                      |        "inventory_quantity": 0,
                      |        "old_inventory_quantity": 0,
                      |        "presentment_prices": [
                      |          {
                      |            "price": {
                      |              "amount": "0.00",
                      |              "currency_code": "USD"
                      |            },
                      |            "compare_at_price": null
                      |          }
                      |        ],
                      |        "requires_shipping": true,
                      |        "admin_graphql_api_id": "gid://shopify/ProductVariant/1070325095"
                      |      }
                      |    ],
                      |    "options": [
                      |      {
                      |        "id": 1055547261,
                      |        "product_id": 1071559625,
                      |        "name": "Title",
                      |        "position": 1,
                      |        "values": [
                      |          "Default Title"
                      |        ]
                      |      }
                      |    ],
                      |    "images": [],
                      |    "image": null
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Product(
        id = Some(632910392),
        title = "Burton Custom Freestyle 151",
        bodyHtml = Some("<strong>Good snowboard!</strong>"),
        vendor = Some("Burton"),
        handle = Some("burton-custom-freestyle-151"),
        updatedAt = "2022-02-03T17:19:42-05:00",
        publishedAt = "2022-02-03T17:19:42-05:00",
        templateSuffix = None,
        status = Some("active"),
        publishedScope = Some("web"),
        tags = Some("Barnes & Noble, Big Air, John's Fav"),
        variants = List(
          ProductVariant(
            id = Some(1070325095),
            productId = 1071559625,
            price = "0.00",
            sku = Some(""),
            position = Some(1),
            inventoryPolicy = Some("deny"),
            compareAtPrice = None,
            fulfillmentService = Some("manual"),
            inventoryManagement = None,
            option1 = Some("Default Title"),
            option2 = None,
            option3 = None,
            createdAt = "2022-02-03T17:19:42-05:00",
            updatedAt = "2022-02-03T17:19:42-05:00",
            taxable = true,
            barcode = None,
            grams = Some(0),
            imageId = None,
            weight = Some(0),
            weightUnit = Some("lb"),
            inventoryItemId = Some(1070325095),
            inventoryQuantity = Some(0),
            presentmentPrices = List(
              PresentmentPrice(
                price = Price(
                  amount = "0.00",
                  currencyCode = "USD"
                ),
                compareAtPrice = None
              )
            ),
            taxCode = None
          )
        ),
        options = List(
          ProductOption(
            id = 1055547261,
            productId = 1071559625,
            name = "Title",
            position = 1,
            values = List("Default Title")
          )
        ),
        images = List.empty,
        productType = "Snowboard",
        createdAt = "2022-02-03T17:19:42-05:00"
      )
    )
  )
}
