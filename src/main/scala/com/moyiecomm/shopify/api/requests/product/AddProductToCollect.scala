package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.{ProductToCollection, collectDecoder, productToCollectionEncoder}
import com.moyiecomm.shopify.api.requests.ShopifyRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import sttp.client3.{Request, ResponseException}
import sttp.model.Uri._

case class AddProductToCollect(productToCollection: ProductToCollection, config: Config)
    extends ShopifyRequest[ProductToCollection, Collect] {
  override val path: String = s"collects.json"

  override def request: Request[Either[ResponseException[String, circe.Error], Collect], Any] =
    RequestBuilder.postRequest(uri"$fullPath", productToCollection)(productToCollectionEncoder, collectDecoder)
}
