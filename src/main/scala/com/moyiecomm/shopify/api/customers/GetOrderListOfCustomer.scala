package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.orders.Order
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
//import Order.orderListDecoder
//
////todo to be test
//case class GetOrderListOfCustomer(customerId: Long, status: Option[String])(implicit val apiConfig: ApiConfig)
//    extends GetItemRequest[List[Order]]()(orderListDecoder) {
//  override def path: String = {
//    s"/customers/$customerId/orders.json${status.map(s => s"?status=$s").getOrElse("")}"
//  }
//}