package com.moyiecomm.shopify.api.v1.plus

case class User(
    accountOwner: Boolean,
    bio: String,
    email: String,
    firstName: String,
    id: Long,
    im: String,
    lastName: String,
    premissions: List[String],
    phone: String,
    receiveAnnouncements: Boolean,
    url: String,
    locale: String,
    userType: String
)
