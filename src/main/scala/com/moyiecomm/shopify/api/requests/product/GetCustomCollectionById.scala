package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.collectionDecoder
import io.circe.Decoder

case class GetCustomCollectionById(id: Long, override val config: Config) extends GetRequest[Collection](config) {

  override val path: String                         = s"/custom_collections/$id.json"
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
