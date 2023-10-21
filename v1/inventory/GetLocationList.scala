package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.Location
import com.moyiecomm.shopify.api.v1.inventory.models.Location.locationListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetLocationList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Location]]()(locationListDecoder) {
  override def path: String = "/locations.json"
}
