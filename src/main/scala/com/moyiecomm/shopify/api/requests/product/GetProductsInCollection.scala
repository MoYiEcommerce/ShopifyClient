package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.productListDecoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder

case class GetProductsInCollection(id: Long, override val config: Config) extends GetRequest[List[Product]](config) {

  override val path: String                            = s"/collections/$id/products.json"
  override val responseDecoder: Decoder[List[Product]] = productListDecoder
}
