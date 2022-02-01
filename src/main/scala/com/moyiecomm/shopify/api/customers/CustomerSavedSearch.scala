package com.moyiecomm.shopify.api.customers

case class CustomerSavedSearch(
    createAt: Long,
    id: Long,
    name: String,
    query: String,
    updateAt: Long
)
