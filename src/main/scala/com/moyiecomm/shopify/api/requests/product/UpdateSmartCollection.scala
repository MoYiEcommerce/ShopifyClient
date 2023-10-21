package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.{smartCollectionDecoder, smartCollectionEncoder}
import com.moyiecomm.shopify.api.requests.PutRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

case class UpdateSmartCollection(smartCollection: SmartCollection, override val config: Config)
    extends PutRequest[SmartCollection, SmartCollection](smartCollection, config) {

  override val path: String = {
    require(smartCollection.id.nonEmpty, "Smart Collection id must not be empty")
    s"/smart_collections/${smartCollection.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[SmartCollection]  = smartCollectionEncoder
  override val responseDecoder: Decoder[SmartCollection] = smartCollectionDecoder
}
