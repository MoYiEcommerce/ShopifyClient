package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import ProductVariant.{productVariantEncoder, productVariantDecoder}

case class UpdateProductVariant(productVariant: ProductVariant)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductVariant, ProductVariant](productVariant)(
      productVariantEncoder,
      productVariantDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(productVariant.id.nonEmpty, "Product Variant id must not be empty")
    s"/variants/${productVariant.id.getOrElse("")}.json"
  }
}
