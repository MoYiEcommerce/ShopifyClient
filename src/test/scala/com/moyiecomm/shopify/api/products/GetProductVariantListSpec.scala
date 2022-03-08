package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price}

class GetProductVariantListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetProductVariantList(632910392),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/variants.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/products/632910392/variants.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "variants": [
                      |      {
                      |      "id": 808950810,
                      |      "product_id": 632910392,
                      |      "title": "Pink",
                      |      "price": "199.00",
                      |      "sku": "IPOD2008PINK",
                      |      "position": 1,
                      |      "inventory_policy": "continue",
                      |      "compare_at_price": null,
                      |      "fulfillment_service": "manual",
                      |      "inventory_management": "shopify",
                      |      "option1": "Pink",
                      |      "option2": null,
                      |      "option3": null,
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "taxable": true,
                      |      "barcode": "1234_pink",
                      |      "grams": 567,
                      |      "image_id": 562641783,
                      |      "weight": 1.25,
                      |      "weight_unit": "lb",
                      |      "inventory_item_id": 808950810,
                      |      "inventory_quantity": 10,
                      |      "old_inventory_quantity": 10,
                      |      "presentment_prices": [
                      |        {
                      |          "price": {
                      |            "amount": "199.00",
                      |            "currency_code": "USD"
                      |          },
                      |          "compare_at_price": null
                      |        }
                      |      ],
                      |      "requires_shipping": true,
                      |      "admin_graphql_api_id": "gid://shopify/ProductVariant/808950810"
                      |    },
                      |    {
                      |      "id": 49148385,
                      |      "product_id": 632910392,
                      |      "title": "Red",
                      |      "price": "199.00",
                      |      "sku": "IPOD2008RED",
                      |      "position": 2,
                      |      "inventory_policy": "continue",
                      |      "compare_at_price": null,
                      |      "fulfillment_service": "manual",
                      |      "inventory_management": "shopify",
                      |      "option1": "Red",
                      |      "option2": null,
                      |      "option3": null,
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "taxable": true,
                      |      "barcode": "1234_red",
                      |      "grams": 567,
                      |      "image_id": null,
                      |      "weight": 1.25,
                      |      "weight_unit": "lb",
                      |      "inventory_item_id": 49148385,
                      |      "inventory_quantity": 20,
                      |      "old_inventory_quantity": 20,
                      |      "presentment_prices": [
                      |        {
                      |          "price": {
                      |            "amount": "199.00",
                      |            "currency_code": "USD"
                      |          },
                      |          "compare_at_price": null
                      |        }
                      |      ],
                      |      "requires_shipping": true,
                      |      "admin_graphql_api_id": "gid://shopify/ProductVariant/49148385"
                      |    },
                      |    {
                      |      "id": 39072856,
                      |      "product_id": 632910392,
                      |      "title": "Green",
                      |      "price": "199.00",
                      |      "sku": "IPOD2008GREEN",
                      |      "position": 3,
                      |      "inventory_policy": "continue",
                      |      "compare_at_price": null,
                      |      "fulfillment_service": "manual",
                      |      "inventory_management": "shopify",
                      |      "option1": "Green",
                      |      "option2": null,
                      |      "option3": null,
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "taxable": true,
                      |      "barcode": "1234_green",
                      |      "grams": 567,
                      |      "image_id": null,
                      |      "weight": 1.25,
                      |      "weight_unit": "lb",
                      |      "inventory_item_id": 39072856,
                      |      "inventory_quantity": 30,
                      |      "old_inventory_quantity": 30,
                      |      "presentment_prices": [
                      |        {
                      |          "price": {
                      |            "amount": "199.00",
                      |            "currency_code": "USD"
                      |          },
                      |          "compare_at_price": null
                      |        }
                      |      ],
                      |      "requires_shipping": true,
                      |      "admin_graphql_api_id": "gid://shopify/ProductVariant/39072856"
                      |    },
                      |    {
                      |      "id": 457924702,
                      |      "product_id": 632910392,
                      |      "title": "Black",
                      |      "price": "199.00",
                      |      "sku": "IPOD2008BLACK",
                      |      "position": 4,
                      |      "inventory_policy": "continue",
                      |      "compare_at_price": null,
                      |      "fulfillment_service": "manual",
                      |      "inventory_management": "shopify",
                      |      "option1": "Black",
                      |      "option2": null,
                      |      "option3": null,
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "updated_at": "2022-03-11T11:02:04-05:00",
                      |      "taxable": true,
                      |      "barcode": "1234_black",
                      |      "grams": 567,
                      |      "image_id": null,
                      |      "weight": 1.25,
                      |      "weight_unit": "lb",
                      |      "inventory_item_id": 457924702,
                      |      "inventory_quantity": 40,
                      |      "old_inventory_quantity": 40,
                      |      "presentment_prices": [
                      |        {
                      |          "price": {
                      |            "amount": "199.00",
                      |            "currency_code": "USD"
                      |          },
                      |          "compare_at_price": null
                      |        }
                      |      ],
                      |      "requires_shipping": true,
                      |      "admin_graphql_api_id": "gid://shopify/ProductVariant/457924702"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        ProductVariant(
          id = Some(808950810),
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
          option1 = Some("Pink"),
          option2 = None,
          option3 = None,
          presentmentPrices = List(
            PresentmentPrice(
              price = Price(amount = "199.00", currencyCode = "USD"),
              compareAtPrice = None
            )
          ),
          position = Some(1),
          price = "199.00",
          productId = 632910392,
          sku = Some("IPOD2008PINK"),
          taxable = true,
          taxCode = None,
          updatedAt = "2022-03-11T11:02:04-05:00",
          weight = Some(1.25),
          weightUnit = Some("lb")
        ),
        ProductVariant(
          id = Some(49148385),
          barcode = Some("1234_red"),
          compareAtPrice = None,
          createdAt = "2022-03-11T11:02:04-05:00",
          fulfillmentService = Some("manual"),
          grams = Some(567),
          imageId = None,
          inventoryItemId = Some(49148385),
          inventoryManagement = Some("shopify"),
          inventoryPolicy = Some("continue"),
          inventoryQuantity = Some(20),
          option1 = Some("Red"),
          option2 = None,
          option3 = None,
          presentmentPrices = List(
            PresentmentPrice(
              price = Price(amount = "199.00", currencyCode = "USD"),
              compareAtPrice = None
            )
          ),
          position = Some(2),
          price = "199.00",
          productId = 632910392,
          sku = Some("IPOD2008RED"),
          taxable = true,
          taxCode = None,
          updatedAt = "2022-03-11T11:02:04-05:00",
          weight = Some(1.25),
          weightUnit = Some("lb")
        ),
        ProductVariant(
          id = Some(39072856),
          barcode = Some("1234_green"),
          compareAtPrice = None,
          createdAt = "2022-03-11T11:02:04-05:00",
          fulfillmentService = Some("manual"),
          grams = Some(567),
          imageId = None,
          inventoryItemId = Some(39072856),
          inventoryManagement = Some("shopify"),
          inventoryPolicy = Some("continue"),
          inventoryQuantity = Some(30),
          option1 = Some("Green"),
          option2 = None,
          option3 = None,
          presentmentPrices = List(
            PresentmentPrice(
              price = Price(amount = "199.00", currencyCode = "USD"),
              compareAtPrice = None
            )
          ),
          position = Some(3),
          price = "199.00",
          productId = 632910392,
          sku = Some("IPOD2008GREEN"),
          taxable = true,
          taxCode = None,
          updatedAt = "2022-03-11T11:02:04-05:00",
          weight = Some(1.25),
          weightUnit = Some("lb")
        ),
        ProductVariant(
          id = Some(457924702),
          barcode = Some("1234_black"),
          compareAtPrice = None,
          createdAt = "2022-03-11T11:02:04-05:00",
          fulfillmentService = Some("manual"),
          grams = Some(567),
          imageId = None,
          inventoryItemId = Some(457924702),
          inventoryManagement = Some("shopify"),
          inventoryPolicy = Some("continue"),
          inventoryQuantity = Some(40),
          option1 = Some("Black"),
          option2 = None,
          option3 = None,
          presentmentPrices = List(
            PresentmentPrice(
              price = Price(amount = "199.00", currencyCode = "USD"),
              compareAtPrice = None
            )
          ),
          position = Some(4),
          price = "199.00",
          productId = 632910392,
          sku = Some("IPOD2008BLACK"),
          taxable = true,
          taxCode = None,
          updatedAt = "2022-03-11T11:02:04-05:00",
          weight = Some(1.25),
          weightUnit = Some("lb")
        )
      )
    )
  )

}
