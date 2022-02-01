package com.moyiecomm.shopify.api.shippingFulfillment

import com.moyiecomm.shopify.api.customers.Address
import com.moyiecomm.shopify.api.orders.LineItem

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
