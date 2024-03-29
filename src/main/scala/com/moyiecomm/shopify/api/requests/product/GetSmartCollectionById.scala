package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.smartCollectionDecoder
import io.circe.Decoder

case class GetSmartCollectionById(smartCollectionId: Long, override val config: Config)
    extends GetRequest[SmartCollection](config) {

  override val path: String                              = s"/smart_collections/$smartCollectionId.json"
  override val responseDecoder: Decoder[SmartCollection] = smartCollectionDecoder
}
