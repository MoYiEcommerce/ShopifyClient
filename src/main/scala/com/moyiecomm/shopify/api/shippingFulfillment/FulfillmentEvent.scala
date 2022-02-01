package com.moyiecomm.shopify.api.shippingFulfillment

case class FulfillmentEvent(
    address1: String,
    city: String,
    country: String,
    createdAt: Long,
    estimatedDeliveryAt: Long,
    fulfillmentId: Long,
    happenedAt: Long,
    id: Long,
    latitude: Double,
    longitude: Double,
    message: String,
    orderId: Long,
    province: String,
    shopId: Long,
    status: String,
    updatedAt: Long,
    zip: String
)
