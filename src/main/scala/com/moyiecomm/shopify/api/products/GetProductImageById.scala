package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductImage
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ProductImage.productImageDecoder

case class GetProductImageById(productId: Long, imageId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ProductImage]()(productImageDecoder) {
  override def path: String = s"/products/$productId/images/$imageId.json"
}
