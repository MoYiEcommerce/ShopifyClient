package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.{collectionDecoder, customCollectionEncoder}
import com.moyiecomm.shopify.api.requests.{PutRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, UriContext}

case class UpdateCustomCollectionById(customCollection: Collection, override val config: Config)
    extends PutRequest[Collection, Collection](customCollection, config) {

  override val path: String = {
    require(customCollection.id.nonEmpty, "custom collection id [must not] be None")
    s"custom_collections/${customCollection.id.getOrElse("")}.json"
  }

  override val requestEncoder: Encoder[Collection]  = customCollectionEncoder
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
