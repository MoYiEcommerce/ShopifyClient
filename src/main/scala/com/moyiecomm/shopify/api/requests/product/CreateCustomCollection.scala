package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.collectionDecoder
import com.moyiecomm.shopify.api.json.product.Collection.customCollectionEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateCustomCollection(collection: Collection, override val config: Config)
    extends PostRequest[Collection, Collection](collection, config) {

  override val path: String                         = "custom_collections.json"
  override val requestEncoder: Encoder[Collection]  = customCollectionEncoder
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
