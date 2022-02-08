package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteProductVariantById(productId: Long, variantId: Long)(implicit val apiConfig: ApiConfig)
    extends DeleteByIdRequest {
  override def path: String = s"/products/$productId/variants/$variantId.json"
}
