package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.ProductVariant
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ProductVariant.productVariantDecoder

case class GetProductVariantById(variantId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ProductVariant]()(productVariantDecoder) {
  override def path: String = s"/variants/$variantId.json"

}
