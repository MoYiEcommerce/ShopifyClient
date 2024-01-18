package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.Location
import io.circe.Decoder

case class GetLocationList(override val config: Config) extends GetRequest[List[Location]](config) {

  override val path: String                             = "locations.json"
  override val responseDecoder: Decoder[List[Location]] = Location.locationListDecoder
}
