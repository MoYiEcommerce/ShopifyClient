package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.{smartCollectionDecoder, smartCollectionEncoder}
import com.moyiecomm.shopify.api.requests.{PostRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, UriContext}

case class CreateSmartCollection(smartCollection: SmartCollection, override val config: Config)
    extends PostRequest[SmartCollection, SmartCollection](smartCollection, config) {

  override val path: String                              = "smart_collections.json"
  override val requestEncoder: Encoder[SmartCollection]  = smartCollectionEncoder
  override val responseDecoder: Decoder[SmartCollection] = smartCollectionDecoder
}
