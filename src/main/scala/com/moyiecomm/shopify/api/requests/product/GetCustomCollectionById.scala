package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.json.product.Collection.collectionDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetCustomCollectionById(id: Long, override val config: Config) extends GetRequest[Collection](config) {

  override val path: String                         = s"/custom_collections/$id.json"
  override val responseDecoder: Decoder[Collection] = collectionDecoder
}
