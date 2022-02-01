package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.Collection.CollectionImage
import com.moyiecomm.shopify.api.products.SmartCollection.Rule

case class SmartCollection(
    bodyHtml: String,
    handle: String,
    image: CollectionImage,
    id: Long,
    publishedAt: Long,
    publishedScope: String,
    rules: List[Rule],
    disjunctive: Boolean,
    sortOrder: String,
    templateSuffix: String,
    title: String,
    updateAt: Long
)

object SmartCollection {
  case class Rule(column: String, relation: String, condition: String)
}
