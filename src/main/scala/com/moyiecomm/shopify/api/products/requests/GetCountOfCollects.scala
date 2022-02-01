package com.moyiecomm.shopify.api.products.requests

import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._

object GetCountOfCollects {
  case class CountOfCollects(count: Int)
  val request = (uriPrefix: String) =>
    basicRequest
      .get(uri"$uriPrefix/ollects/count.json")
      .response(asJson[CountOfCollects])
}
