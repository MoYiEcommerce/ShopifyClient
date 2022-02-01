package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.products.Collection
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._

object GetCollectionById {
  val request = (uriPrefix: String, id: Long) =>
    basicRequest
      .get(uri"$uriPrefix/collections/$id.json")
      .response(asJson[Collection])
}
