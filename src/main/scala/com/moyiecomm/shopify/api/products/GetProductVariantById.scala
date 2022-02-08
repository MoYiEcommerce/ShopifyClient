package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetProductVariantById(productId: Long, variantId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ProductVariant] {
  override def path: String = s"/products/$productId/variants/$variantId.json"

}
