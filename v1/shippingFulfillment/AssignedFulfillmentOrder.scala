package com.moyiecomm.shopify.api.v1.shippingFulfillment

import com.moyiecomm.shopify.api.v1.customers.models.Address
import com.moyiecomm.shopify.api.v1.shared.models.LineItem

case class AssignedFulfillmentOrder(
    assignedLocationId: Long,
    destination: Address,
    id: Long,
    lineItems: List[LineItem],
    orderId: Long,
    requestStatus: String,
    shopId: Long,
    status: String
)
