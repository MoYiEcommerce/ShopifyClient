package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.{Product, ProductImage, ProductVariant}
import com.moyiecomm.shopify.api.shared.models.{PresentmentPrice, Price, ProductOption}

class GetProductsInCollectionSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetProductsInCollection(841564295),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collections/841564295/products.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/collections/841564295/products.json")
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
                      |      "created_at": "2022-04-05T13:17:47-04:00",
                      |      "handle": "ipod-nano",
                      |      "updated_at": "2022-04-05T13:17:47-04:00",
                      |      "published_at": "2007-12-31T19:00:00-05:00",
                      |      "template_suffix": null,
                      |      "published_scope": "web",
                      |      "tags": "Emotive, Flash Memory, MP3, Music",
                      |      "admin_graphql_api_id": "gid://shopify/Product/632910392",
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
                      |          "created_at": "2022-04-05T13:17:47-04:00",
                      |          "updated_at": "2022-04-05T13:17:47-04:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1649179067",
                      |          "variant_ids": [],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/850703190"
                      |        },
                      |        {
                      |          "id": 562641783,
                      |          "product_id": 632910392,
                      |          "position": 2,
                      |          "created_at": "2022-04-05T13:17:47-04:00",
                      |          "updated_at": "2022-04-05T13:17:47-04:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano-2.png?v=1649179067",
                      |          "variant_ids": [
                      |            808950810
                      |          ],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/562641783"
                      |        },
                      |        {
                      |          "id": 378407906,
                      |          "product_id": 632910392,
                      |          "position": 3,
                      |          "created_at": "2022-04-05T13:17:47-04:00",
                      |          "updated_at": "2022-04-05T13:17:47-04:00",
                      |          "alt": null,
                      |          "width": 123,
                      |          "height": 456,
                      |          "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1649179067",
                      |          "variant_ids": [],
                      |          "admin_graphql_api_id": "gid://shopify/ProductImage/378407906"
                      |        }
                      |      ],
                      |      "variants": [],
                      |      "image": {
                      |        "id": 850703190,
                      |        "product_id": 632910392,
                      |        "position": 1,
                      |        "created_at": "2022-04-05T13:17:47-04:00",
                      |        "updated_at": "2022-04-05T13:17:47-04:00",
                      |        "alt": null,
                      |        "width": 123,
                      |        "height": 456,
                      |        "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1649179067",
                      |        "variant_ids": [],
                      |        "admin_graphql_api_id": "gid://shopify/ProductImage/850703190"
                      |      }
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
            "<p>It's the small iPod with one very big idea: Video. Now the world's most popular music player, available in 4GB and 8GB models, lets you enjoy TV shows, movies, video podcasts, and more. The larger, brighter display means amazing picture quality. In six eye-catching colors, iPod nano is stunning all around. And with models starting at just $149, little speaks volumes.</p>"
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
              variantIds = List.empty,
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1649179067"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-04-05T13:17:47-04:00",
              updatedAt = "2022-04-05T13:17:47-04:00",
              attachment = None
            ),
            ProductImage(
              id = Some(562641783),
              filename = None,
              alt = None,
              position = Some(2),
              productId = 632910392,
              variantIds = List(808950810),
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano-2.png?v=1649179067"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-04-05T13:17:47-04:00",
              updatedAt = "2022-04-05T13:17:47-04:00",
              attachment = None
            ),
            ProductImage(
              id = Some(378407906),
              filename = None,
              alt = None,
              position = Some(3),
              productId = 632910392,
              variantIds = List.empty,
              src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1649179067"),
              width = Some(123),
              height = Some(456),
              createdAt = "2022-04-05T13:17:47-04:00",
              updatedAt = "2022-04-05T13:17:47-04:00",
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
          variants = List.empty,
          createdAt = "2022-04-05T13:17:47-04:00",
          updatedAt = "2022-04-05T13:17:47-04:00",
          publishedAt = "2007-12-31T19:00:00-05:00"
        )
      )
    )
  )
}
