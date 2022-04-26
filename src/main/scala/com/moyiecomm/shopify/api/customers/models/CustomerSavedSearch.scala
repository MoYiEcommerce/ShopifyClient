package com.moyiecomm.shopify.api.customers.models

case class CustomerSavedSearch(
    createAt: Long,
    id: Long,
    name: String,
    query: String,
    updateAt: Long
)
