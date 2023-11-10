package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.collectionDecoder
import com.moyiecomm.shopify.api.json.product.Collection.customCollectionEncoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder
import io.circe.Encoder

case class UpdateCustomCollectionById(customCollection: Collection, override val config: Config)
    extends PutRequest[Collection, Collection](customCollection, config) {

  override val path: String = {
    require(customCollection.id.nonEmpty, "custom collection id [must not] be None")
    s"custom_collections/${customCollection.id.getOrElse("")}.json"
  }

  override val requestEncoder: Encoder[Collection]  = customCollectionEncoder
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
