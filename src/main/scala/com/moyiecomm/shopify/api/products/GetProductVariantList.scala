package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductVariant
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ProductVariant.productVariantListDecoder

case class GetProductVariantList(productId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[ProductVariant]]()(productVariantListDecoder) {
  override def path: String = s"/products/$productId/variants.json"
}
