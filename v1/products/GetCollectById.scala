package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.Collect
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Collect.collectDecoder

case class GetCollectById(id: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Collect]()(collectDecoder) {
  override def path: String = s"/collects/$id.json"
}
