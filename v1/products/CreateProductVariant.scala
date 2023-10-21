package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.ProductVariant
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import ProductVariant.{productVariantEncoder, productVariantDecoder}

case class CreateProductVariant(productVariant: ProductVariant)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductVariant, ProductVariant](productVariant)(
      productVariantEncoder,
      productVariantDecoder
    ) {
  override def method: Method = Method.POST
  override def path: String   = s"/products/${productVariant.productId}/variants.json"
}
