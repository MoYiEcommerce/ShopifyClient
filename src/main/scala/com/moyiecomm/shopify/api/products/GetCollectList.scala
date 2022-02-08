package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collect
import Collect.collectListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCollectList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Collect]]()(collectListDecoder) {
  override def path: String = "/collects.json"
}
