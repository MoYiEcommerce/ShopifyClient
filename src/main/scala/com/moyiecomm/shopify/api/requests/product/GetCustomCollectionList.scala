package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.customCollectionListDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetCustomCollectionList(override val config: Config) extends GetRequest[List[Collection]](config) {

  override val path: String                               = "/custom_collections.json"
  override val responseDecoder: Decoder[List[Collection]] = customCollectionListDecoder
}
