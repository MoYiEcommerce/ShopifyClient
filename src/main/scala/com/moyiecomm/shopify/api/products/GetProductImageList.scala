package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductImage
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetProductImageList(productId: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[ProductImage]] {
  override def path: String = s"products/$productId/images.json"
}
