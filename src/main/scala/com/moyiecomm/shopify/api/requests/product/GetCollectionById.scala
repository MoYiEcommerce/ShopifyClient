package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.collectionDecoder
import com.moyiecomm.shopify.api.requests.{GetRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import io.circe.Decoder
import sttp.client3.{Request, ResponseException, UriContext}

case class GetCollectionById(id: Long, override val config: Config) extends GetRequest[Collection](config) {
  override val path: String                         = s"collections/$id.json"
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
