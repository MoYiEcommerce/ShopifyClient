package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.Location
import com.moyiecomm.shopify.api.inventory.models.Location.locationListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetLocationList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Location]]()(locationListDecoder) {
  override def path: String = "/locations.json"
}
