package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.json.product.SmartCollection
import com.moyiecomm.shopify.api.json.product.SmartCollection.smartCollectionListDecoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder

case class GetSmartCollectionList(override val config: Config) extends GetRequest[List[SmartCollection]](config) {

  override val path: String                                    = s"/smart_collections.json"
  override val responseDecoder: Decoder[List[SmartCollection]] = smartCollectionListDecoder
}
