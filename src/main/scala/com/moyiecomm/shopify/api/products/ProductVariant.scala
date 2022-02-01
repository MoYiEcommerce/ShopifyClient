package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.others.Price
import com.moyiecomm.shopify.api.products.ProductVariant.PresentmentPrice

case class ProductVariant(
    barcode: String,
    compareAtPrice: String,
    createAt: Long,
    fulfillmentService: String,
    grams: Int,
    id: Long,
    imageId: Long,
    inventoryItemId: Long,
    inventoryManagement: String,
    inventoryPolicy: String,
    inventoryQuantity: Int,
    option1: String,
    option2: String,
    option3: String,
    presentmentPrice: List[PresentmentPrice],
    position: Int,
    price: String,
    productId: Long,
    sku: String,
    taxable: Boolean,
    taxCode: String,
    title: String,
    updateAt: Long,
    weight: Int,
    weightUnit: String
)

object ProductVariant {

  case class PresentmentPrice(price: Price, compareAtPrice: Price)
}
