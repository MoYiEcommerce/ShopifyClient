package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.{collectionDecoder, customCollectionEncoder}
import com.moyiecomm.shopify.api.requests.{PostRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, UriContext}

case class CreateCustomCollection(collection: Collection, override val config: Config)
    extends PostRequest[Collection, Collection](collection, config) {

  override val path: String                         = "custom_collections.json"
  override val requestEncoder: Encoder[Collection]  = customCollectionEncoder
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
