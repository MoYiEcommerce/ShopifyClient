package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.{ProductToCollection, collectDecoder, productToCollectionEncoder}
import com.moyiecomm.shopify.api.requests.PostRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

case class AddProductToCollect(productToCollection: ProductToCollection, override val config: Config)
    extends PostRequest[ProductToCollection, Collect](productToCollection, config) {

  override val path: String                                 = s"collects.json"
  override val requestEncoder: Encoder[ProductToCollection] = productToCollectionEncoder
  override val responseDecoder: Decoder[Collect]            = collectDecoder
}
