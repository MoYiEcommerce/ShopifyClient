package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductImage
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import ProductImage.{productImageEncoder, productImageDecoder}

case class CreateProductImage(productImage: ProductImage)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductImage, ProductImage](productImage)(
      productImageEncoder,
      productImageDecoder
    ) {
  override def method: Method = Method.POST
  override def path: String   = s"/products/${productImage.productId}/images.json"
}
