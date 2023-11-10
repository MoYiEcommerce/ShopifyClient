package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.smartCollectionDecoder
import com.moyiecomm.shopify.api.json.product.SmartCollection.smartCollectionEncoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder
import io.circe.Encoder

case class CreateSmartCollection(smartCollection: SmartCollection, override val config: Config)
    extends PostRequest[SmartCollection, SmartCollection](smartCollection, config) {

  override val path: String                              = "smart_collections.json"
  override val requestEncoder: Encoder[SmartCollection]  = smartCollectionEncoder
  override val responseDecoder: Decoder[SmartCollection] = smartCollectionDecoder
}
