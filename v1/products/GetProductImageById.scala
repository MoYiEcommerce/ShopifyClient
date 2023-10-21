package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.ProductImage
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ProductImage.productImageDecoder

case class GetProductImageById(productId: Long, imageId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ProductImage]()(productImageDecoder) {
  override def path: String = s"/products/$productId/images/$imageId.json"
}
