package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.smartCollectionDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetSmartCollectionById(smartCollectionId: Long, override val config: Config)
    extends GetRequest[SmartCollection](config) {

  override val path: String                              = s"/smart_collections/$smartCollectionId.json"
  override val responseDecoder: Decoder[SmartCollection] = smartCollectionDecoder
}
