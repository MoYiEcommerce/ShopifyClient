package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Product
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Product.productListDecoder

case class GetProductsInCollection(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Product]]()(productListDecoder) {

  override def path: String = s"/collections/$id/products.json"

}
