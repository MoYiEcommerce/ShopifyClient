package com.moyiecomm.shopify.api.events

case class Event(
    arguments: String,
    body: String,
    createdAt: Long,
    id: Long,
    path: String,
    message: String,
    subjectId: Long,
    subjectType: String,
    verb: String
)
