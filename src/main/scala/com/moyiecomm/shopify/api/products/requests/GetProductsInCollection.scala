package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.products.Product
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._

object GetProductsInCollection {
  val request = (uriPrefix: String, id: Long) =>
    basicRequest
      .get(uri"$uriPrefix/collections/$id/products.json")
      .response(asJson[List[Product]])
}
