package com.moyiecomm.shopify.api.shippingFulfillment

import com.moyiecomm.shopify.api.shippingFulfillment.LocationsForMove.CanBeMoveToLocation

case class LocationsForMove(locationsForMove: List[CanBeMoveToLocation])

object LocationsForMove {
  case class CanBeMoveToLocation()
}
