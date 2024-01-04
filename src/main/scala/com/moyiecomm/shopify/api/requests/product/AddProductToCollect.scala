package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.ProductToCollection
import com.moyiecomm.shopify.api.json.product.Collect.collectDecoder
import com.moyiecomm.shopify.api.json.product.Collect.productToCollectionEncoder
import io.circe.Decoder
import io.circe.Encoder

case class AddProductToCollect(productToCollection: ProductToCollection, override val config: Config)
    extends PostRequest[ProductToCollection, Collect](productToCollection, config) {

  override val path: String                                 = s"collects.json"
  override val requestEncoder: Encoder[ProductToCollection] = productToCollectionEncoder
  override val responseDecoder: Decoder[Collect]            = collectDecoder
}
