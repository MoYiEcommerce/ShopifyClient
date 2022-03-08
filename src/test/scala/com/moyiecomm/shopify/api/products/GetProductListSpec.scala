package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.{Product, ProductImage, ProductVariant}
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price, ProductOption}

class GetProductListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetProductList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/products.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "products": [
                      |    {
                      |      "id": 632910392,
                      |      "title": "IPod Nano - 8GB",
                      |      "body_html": "<p>It's the small iPod with one very big idea: Video. Now the world's most popular music player, available in 4GB and 8GB models, lets you enjoy TV shows, movies, video podcasts, and more. The larger, brighter display means amazing picture quality. In six eye-catching colors, iPod nano is stunning all around. And with models starting at just $149, little speaks volumes.</p>",
                      |      "vendor": "Apple",
                      |      "product_type": "Cult Products",
                      |      "created_at": "2022-03-11T11:29:03-05:00",
                      |      "handle": "ipod-nano",
                      |      "updated_at": "2022-03-11T11:29:03-05:00",
                      |      "published_at": "2007-12-31T19:00:00-05:00",
                      |      "template_suffix": null,
                      |      "published_scope": "web",
                      |      "tags": "Emotive, Flash Memory, MP3, Music",
                      |      "admin_graphql_api_id": "gid://shopify/Product/632910392",
                      |      "variants": [
                      |        {
                      |          "id": 808950810,
                      |          "product_id": 632910392,
                      |          "title": "Pink",
                      |          "price": "199.00",
                      |          "sku": "IPOD2008PINK",
                      |          "position": 1,
                      |          "inventory_policy": "continue",
                      |          "compare_at_price": null,
                      |          "fulfillment_service": "manual",
                      |          "inventory_management": "shopify",
                      |          "option1": "Pink",
                      |          "option2": null,
                      |          "option3": null,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "taxable": true,
                      |          "barcode": "1234_pink",
                      |          "grams": 567,
                      |          "image_id": 562641783,
                      |          "weight": 1.25,
                      |          "weight_unit": "lb",
                      |          "inventory_item_id": 808950810,
                      |          "inventory_quantity": 10,
                      |          "old_inventory_quantity": 10,
                      |          "presentment_prices": [
                      |            {
                      |              "price": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "compare_at_price": null
                      |            }
                      |          ],
                      |          "requires_shipping": true,
                      |          "admin_graphql_api_id": "gid://shopify/ProductVariant/808950810"
                      |        },
                      |        {
                      |          "id": 49148385,
                      |          "product_id": 632910392,
                      |          "title": "Red",
                      |          "price": "199.00",
                      |          "sku": "IPOD2008RED",
                      |          "position": 2,
                      |          "inventory_policy": "continue",
                      |          "compare_at_price": null,
                      |          "fulfillment_service": "manual",
                      |          "inventory_management": "shopify",
                      |          "option1": "Red",
                      |          "option2": null,
                      |          "option3": null,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "taxable": true,
                      |          "barcode": "1234_red",
                      |          "grams": 567,
                      |          "image_id": null,
                      |          "weight": 1.25,
                      |          "weight_unit": "lb",
                      |          "inventory_item_id": 49148385,
                      |          "inventory_quantity": 20,
                      |          "old_inventory_quantity": 20,
                      |          "presentment_prices": [
                      |            {
                      |              "price": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "compare_at_price": null
                      |            }
                      |          ],
                      |          "requires_shipping": true,
                      |          "admin_graphql_api_id": "gid://shopify/ProductVariant/49148385"
                      |        },
                      |        {
                      |          "id": 39072856,
                      |          "product_id": 632910392,
                      |          "title": "Green",
                      |          "price": "199.00",
                      |          "sku": "IPOD2008GREEN",
                      |          "position": 3,
                      |          "inventory_policy": "continue",
                      |          "compare_at_price": null,
                      |          "fulfillment_service": "manual",
                      |          "inventory_management": "shopify",
                      |          "option1": "Green",
                      |          "option2": null,
                      |          "option3": null,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "taxable": true,
                      |          "barcode": "1234_green",
                      |          "grams": 567,
                      |          "image_id": null,
                      |          "weight": 1.25,
                      |          "weight_unit": "lb",
                      |          "inventory_item_id": 39072856,
                      |          "inventory_quantity": 30,
                      |          "old_inventory_quantity": 30,
                      |          "presentment_prices": [
                      |            {
                      |              "price": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "compare_at_price": null
                      |            }
                      |          ],
                      |          "requires_shipping": true,
                      |          "admin_graphql_api_id": "gid://shopify/ProductVariant/39072856"
                      |        },
                      |        {
                      |          "id": 457924702,
                      |          "product_id": 632910392,
                      |          "title": "Black",
                      |          "price": "199.00",
                      |          "sku": "IPOD2008BLACK",
                      |          "position": 4,
                      |          "inventory_policy": "continue",
                      |          "compare_at_price": null,
                      |          "fulfillment_service": "manual",
                      |          "inventory_management": "shopify",
                      |          "option1": "Black",
                      |          "option2": null,
                      |          "option3": null,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "taxable": true,
                      |          "barcode": "1234_black",
                      |          "grams": 567,
                      |          "image_id": null,
                      |          "weight": 1.25,
                      |          "weight_unit": "lb",
                      |          "inventory_item_id": 457924702,
                      |          "inventory_quantity": 40,
                      |          "old_inventory_quantity": 40,
                      |          "presentment_prices": [
                      |            {
                      |              "price": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "compare_at_price": null
                      |            }
                      |          ],
                      |          "requires_shipping": true,
                      |          "admin_graphql_api_id": "gid://shopify/ProductVariant/457924702"
                      |        }
                      |      ],
                      |      "options": [
                      |        {
                      |          "id": 594680422,
                      |          "product_id": 632910392,
                      |          "name": "Color",
                      |          "position": 1,
                      |          "values": [
                      |            "Pink",
                      |            "Red",
                      |            "Green",
                      |            "Black"
                      |          ]
                      |        }
                      |      ],
                      |      "images": [
                      |        {
                      |          "id": 850703190,
                      |          "product_id": 632910392,
                      |          "position": 1,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647016143",
                      |          "variant_ids": [],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/850703190"
                      |        },
                      |        {
                      |          "id": 562641783,
                      |          "product_id": 632910392,
                      |          "position": 2,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano-2.png?v=1647016143",
                      |          "variant_ids": [
                      |            808950810
                      |          ],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/562641783"
                      |        },
                      |        {
                      |          "id": 378407906,
                      |          "product_id": 632910392,
                      |          "position": 3,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647016143",
                      |          "variant_ids": [],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/378407906"
                      |        }
                      |      ],
                      |      "image": {
                      |        "id": 850703190,
                      |        "product_id": 632910392,
                      |        "position": 1,
                      |        "created_at": "2022-03-11T11:29:03-05:00",
                      |        "updated_at": "2022-03-11T11:29:03-05:00",
                      |        "alt": null,
                      |        "width": 123,
                      |        "height": 456,
                      |        "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647016143",
                      |        "variant_ids": [],
                      |        "admin_graphql_api_id": "gid://shopify/ProductImage/850703190"
                      |      }
                      |    },
                      |    {
                      |      "id": 921728736,
                      |      "title": "IPod Touch 8GB",
                      |      "body_html": "<p>The iPod Touch has the iPhone's multi-touch interface, with a physical home button off the touch screen. The home screen has a list of buttons for the available applications.</p>",
                      |      "vendor": "Apple",
                      |      "product_type": "Cult Products",
                      |      "created_at": "2022-03-11T11:29:03-05:00",
                      |      "handle": "ipod-touch",
                      |      "updated_at": "2022-03-11T11:29:03-05:00",
                      |      "published_at": "2008-09-25T20:00:00-04:00",
                      |      "template_suffix": null,
                      |      "published_scope": "web",
                      |      "tags": "",
                      |      "admin_graphql_api_id": "gid://shopify/Product/921728736",
                      |      "variants": [
                      |        {
                      |          "id": 447654529,
                      |          "product_id": 921728736,
                      |          "title": "Black",
                      |          "price": "199.00",
                      |          "sku": "IPOD2009BLACK",
                      |          "position": 1,
                      |          "inventory_policy": "continue",
                      |          "compare_at_price": null,
                      |          "fulfillment_service": "shipwire-app",
                      |          "inventory_management": "shipwire-app",
                      |          "option1": "Black",
                      |          "option2": null,
                      |          "option3": null,
                      |          "created_at": "2022-03-11T11:29:03-05:00",
                      |          "updated_at": "2022-03-11T11:29:03-05:00",
                      |          "taxable": true,
                      |          "barcode": "1234_black",
                      |          "grams": 567,
                      |          "image_id": null,
                      |          "weight": 1.25,
                      |          "weight_unit": "lb",
                      |          "inventory_item_id": 447654529,
                      |          "inventory_quantity": 13,
                      |          "old_inventory_quantity": 13,
                      |          "presentment_prices": [
                      |            {
                      |              "price": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "compare_at_price": null
                      |            }
                      |          ],
                      |          "requires_shipping": true,
                      |          "admin_graphql_api_id": "gid://shopify/ProductVariant/447654529"
                      |        }
                      |      ],
                      |      "options": [
                      |        {
                      |          "id": 891236591,
                      |          "product_id": 921728736,
                      |          "name": "Title",
                      |          "position": 1,
                      |          "values": [
                      |            "Black"
                      |          ]
                      |        }
                      |      ],
                      |      "images": [],
                      |      "image": null
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Product(
          id = Some(632910392),
          title = "IPod Nano - 8GB",
          bodyHtml = Some(
            """<p>It's the small iPod with one very big idea: Video. Now the world's most popular music player, available in 4GB and 8GB models, lets you enjoy TV shows, movies, video podcasts, and more. The larger, brighter display means amazing picture quality. In six eye-catching colors, iPod nano is stunning all around. And with models starting at just $149, little speaks volumes.</p>""".stripMargin
          ),
          handle = Some("ipod-nano"),
          vendor = Some("Apple"),
          images = List(
            ProductImage(
              id = Some(850703190),
              filename = None,
              alt = None,
              position = Some(1),
              productId = 632910392,
              variantIds = List(),
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647016143"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-03-11T11:29:03-05:00",
              updatedAt = "2022-03-11T11:29:03-05:00",
              attachment = None
            ),
            ProductImage(
              id = Some(562641783),
              filename = None,
              alt = None,
              position = Some(2),
              productId = 632910392,
              variantIds = List(808950810),
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano-2.png?v=1647016143"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-03-11T11:29:03-05:00",
              updatedAt = "2022-03-11T11:29:03-05:00",
              attachment = None
            ),
            ProductImage(
              id = Some(378407906),
              filename = None,
              alt = None,
              position = Some(3),
              productId = 632910392,
              variantIds = List(),
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647016143"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-03-11T11:29:03-05:00",
              updatedAt = "2022-03-11T11:29:03-05:00",
              attachment = None
            )
          ),
          options = List(
            ProductOption(
              id = 594680422,
              productId = 632910392,
              name = "Color",
              position = 1,
              values = List("Pink", "Red", "Green", "Black")
            )
          ),
          productType = "Cult Products",
          publishedScope = Some("web"),
          status = None,
          tags = Some("Emotive, Flash Memory, MP3, Music"),
          templateSuffix = None,
          variants = List(
            ProductVariant(
              id = Some(808950810),
              barcode = Some("1234_pink"),
              compareAtPrice = None,
              createdAt = "2022-03-11T11:29:03-05:00",
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
              updatedAt = "2022-03-11T11:29:03-05:00",
              weight = Some(1.25),
              weightUnit = Some("lb")
            ),
            ProductVariant(
              id = Some(49148385),
              barcode = Some("1234_red"),
              compareAtPrice = None,
              createdAt = "2022-03-11T11:29:03-05:00",
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
              updatedAt = "2022-03-11T11:29:03-05:00",
              weight = Some(1.25),
              weightUnit = Some("lb")
            ),
            ProductVariant(
              id = Some(39072856),
              barcode = Some("1234_green"),
              compareAtPrice = None,
              createdAt = "2022-03-11T11:29:03-05:00",
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
              updatedAt = "2022-03-11T11:29:03-05:00",
              weight = Some(1.25),
              weightUnit = Some("lb")
            ),
            ProductVariant(
              id = Some(457924702),
              barcode = Some("1234_black"),
              compareAtPrice = None,
              createdAt = "2022-03-11T11:29:03-05:00",
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
              updatedAt = "2022-03-11T11:29:03-05:00",
              weight = Some(1.25),
              weightUnit = Some("lb")
            )
          ),
          createdAt = "2022-03-11T11:29:03-05:00",
          publishedAt = "2007-12-31T19:00:00-05:00",
          updatedAt = "2022-03-11T11:29:03-05:00"
        ),
        Product(
          id = Some(921728736),
          title = "IPod Touch 8GB",
          bodyHtml = Some(
            "<p>The iPod Touch has the iPhone's multi-touch interface, with a physical home button off the touch screen. The home screen has a list of buttons for the available applications.</p>"
          ),
          handle = Some("ipod-touch"),
          vendor = Some("Apple"),
          images = List.empty,
          options = List(
            ProductOption(
              id = 891236591,
              productId = 921728736,
              name = "Title",
              position = 1,
              values = List("Black")
            )
          ),
          productType = "Cult Products",
          publishedScope = Some("web"),
          status = None,
          tags = Some(""), // todo fix this
          templateSuffix = None,
          variants = List(
            ProductVariant(
              id = Some(447654529),
              barcode = Some("1234_black"),
              compareAtPrice = None,
              createdAt = "2022-03-11T11:29:03-05:00",
              fulfillmentService = Some("shipwire-app"),
              grams = Some(567),
              imageId = None,
              inventoryItemId = Some(447654529),
              inventoryManagement = Some("shipwire-app"),
              inventoryPolicy = Some("continue"),
              inventoryQuantity = Some(13),
              option1 = Some("Black"),
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
              productId = 921728736,
              sku = Some("IPOD2009BLACK"),
              taxable = true,
              taxCode = None,
              updatedAt = "2022-03-11T11:29:03-05:00",
              weight = Some(1.25),
              weightUnit = Some("lb")
            )
          ),
          createdAt = "2022-03-11T11:29:03-05:00",
          publishedAt = "2008-09-25T20:00:00-04:00",
          updatedAt = "2022-03-11T11:29:03-05:00"
        )
      )
    )
  )

}
