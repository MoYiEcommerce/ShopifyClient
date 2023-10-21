package com.moyiecomm.shopify.api.requests

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, equalTo, options, post}
import com.moyiecomm.shopify.api.RequestSpec
import com.moyiecomm.shopify.api.json.product.{Product, ProductVariant}
import com.moyiecomm.shopify.api.json.shared.{PresentmentPrice, Price, ProductOption}
import com.moyiecomm.shopify.api.requests.product.CreateProduct
import sttp.model.StatusCode

import java.time.ZonedDateTime

class CreateProductSpec extends RequestSpec {
  it should behave like correctRequestResponse(
    mockRequest = post("/admin/api/2023-10/products.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"product":{"title":"Burton Custom Freestyle 151","body_html":"<strong>Good snowboard!</strong>","vendor":"Burton","product_type":"Snowboard","status":"draft"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "product": {
                      |    "id": 1072481042,
                      |    "title": "Burton Custom Freestyle 151",
                      |    "body_html": "<strong>Good snowboard!</strong>",
                      |    "vendor": "Burton",
                      |    "product_type": "Snowboard",
                      |    "created_at": "2023-10-03T13:23:57-04:00",
                      |    "handle": "burton-custom-freestyle-151",
                      |    "updated_at": "2023-10-03T13:23:57-04:00",
                      |    "published_at": null,
                      |    "template_suffix": null,
                      |    "published_scope": "web",
                      |    "tags": "",
                      |    "status": "draft",
                      |    "admin_graphql_api_id": "gid://shopify/Product/1072481042",
                      |    "variants": [
                      |      {
                      |        "id": 1070325019,
                      |        "product_id": 1072481042,
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
                      |        "created_at": "2023-10-03T13:23:57-04:00",
                      |        "updated_at": "2023-10-03T13:23:57-04:00",
                      |        "taxable": true,
                      |        "barcode": null,
                      |        "grams": 0,
                      |        "image_id": null,
                      |        "weight": 0,
                      |        "weight_unit": "lb",
                      |        "inventory_item_id": 1070325019,
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
                      |        "admin_graphql_api_id": "gid://shopify/ProductVariant/1070325019"
                      |      }
                      |    ],
                      |    "options": [
                      |      {
                      |        "id": 1055547176,
                      |        "product_id": 1072481042,
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
    shopifyRequest = CreateProduct(
      Product(
        id = None,
        title = "Burton Custom Freestyle 151",
        bodyHtml = Some("<strong>Good snowboard!</strong>"),
        handle = None,
        vendor = Some("Burton"),
        images = List.empty,
        options = List.empty,
        productType = "Snowboard",
        publishedScope = None,
        status = Some("draft"),
        tags = None,
        templateSuffix = None,
        variants = List.empty,
        createdAt = None,
        publishedAt = None,
        updatedAt = None
      ),
      requestConfig
    ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseEntity = Product(
      id = Some(1072481042),
      title = "Burton Custom Freestyle 151",
      bodyHtml = Some("<strong>Good snowboard!</strong>"),
      handle = Some("burton-custom-freestyle-151"),
      vendor = Some("Burton"),
      images = List.empty,
      options = List(
        ProductOption(
          id = 1055547176,
          productId = 1072481042,
          name = "Title",
          position = 1,
          values = List("Default Title")
        )
      ),
      productType = "Snowboard",
      publishedScope = Some("web"),
      status = Some("draft"),
      tags = Some(""), // todo convert to None
      templateSuffix = None,
      variants = List(
        ProductVariant(
          id = Some(1070325019),
          barcode = None,
          compareAtPrice = None,
          createdAt = Some(ZonedDateTime.parse("2023-10-03T13:23:57-04:00")),
          fulfillmentService = Some("manual"),
          grams = Some(0),
          imageId = None,
          inventoryItemId = Some(1070325019),
          inventoryManagement = None,
          inventoryPolicy = Some("deny"),
          inventoryQuantity = Some(0),
          option1 = Some("Default Title"),
          option2 = None,
          option3 = None,
          position = Some(1),
          price = "0.00",
          presentmentPrices = List(
            PresentmentPrice(
              price = Price(amount = "0.00", currencyCode = "USD"),
              compareAtPrice = None
            )
          ),
          productId = 1072481042,
          sku = Some(""), // todo convert to None
          taxable = true,
          taxCode = None,
          updatedAt = Some(ZonedDateTime.parse("2023-10-03T13:23:57-04:00")),
          weight = Some(0),
          weightUnit = Some("lb")
        )
      ),
      createdAt = Some(ZonedDateTime.parse("2023-10-03T13:23:57-04:00")),
      publishedAt = None,
      updatedAt = Some(ZonedDateTime.parse("2023-10-03T13:23:57-04:00"))
    )
  )
}
