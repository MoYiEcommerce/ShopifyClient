package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.products.Collect
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._

object GetCollectList {
  val request = (uriPrefix: String) =>
    basicRequest
      .get(uri"$uriPrefix/collects.json")
      .response(asJson[List[Collect]])
}
