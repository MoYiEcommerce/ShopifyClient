package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.customCollectionListDecoder
import io.circe.Decoder

case class GetCustomCollectionList(override val config: Config) extends GetRequest[List[Collection]](config) {

  override val path: String                               = "/custom_collections.json"
  override val responseDecoder: Decoder[List[Collection]] = customCollectionListDecoder
}
