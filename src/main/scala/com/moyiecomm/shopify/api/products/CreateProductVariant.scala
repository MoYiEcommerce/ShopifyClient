package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import ProductVariant.{productVariantEncoder, productVariantDecoder}

case class CreateProductVariant(productId: Long, productVariant: ProductVariant)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductVariant, ProductVariant](productVariant) {
  override def method: Method = Method.POST
  override def path: String   = s"/products/$productId/variants.json"
}
