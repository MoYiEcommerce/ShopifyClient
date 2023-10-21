package com.moyiecomm.shopify.api.v1.inventory

import com.moyiecomm.shopify.api.v1.inventory.models.Location
import com.moyiecomm.shopify.api.v1.inventory.models.Location.locationDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetLocationById(locationId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Location]()(locationDecoder) {
  override def path: String = s"/locations/$locationId.json"
}
