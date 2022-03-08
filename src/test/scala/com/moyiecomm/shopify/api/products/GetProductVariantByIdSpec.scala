package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price}

class GetProductVariantByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetProductVariantById(808950810),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/variants/808950810.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/variants/808950810.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "variant": {
                      |    "id": 808950810,
                      |    "product_id": 632910392,
                      |    "title": "Pink",
                      |    "price": "199.00",
                      |    "sku": "IPOD2008PINK",
                      |    "position": 1,
                      |    "inventory_policy": "continue",
                      |    "compare_at_price": null,
                      |    "fulfillment_service": "manual",
                      |    "inventory_management": "shopify",
                      |    "option1": "Pink",
                      |    "option2": null,
                      |    "option3": null,
                      |    "created_at": "2022-03-11T11:02:04-05:00",
                      |    "updated_at": "2022-03-11T11:02:04-05:00",
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
                      |          "amount": "199.00",
                      |          "currency_code": "USD"
                      |        },
                      |        "compare_at_price": null
                      |      }
                      |    ],
                      |    "tax_code": "DA040000",
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
        taxCode = Some("DA040000"),
        updatedAt = "2022-03-11T11:02:04-05:00",
        weight = Some(1.25),
        weightUnit = Some("lb")
      )
    )
  )
}
