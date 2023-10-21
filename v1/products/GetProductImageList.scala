package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.ProductImage
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ProductImage.productImageListDecoder

case class GetProductImageList(productId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[ProductImage]]()(productImageListDecoder) {
  override def path: String = s"/products/$productId/images.json"
}
