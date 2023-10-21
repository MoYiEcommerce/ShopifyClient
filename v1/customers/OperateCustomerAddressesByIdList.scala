package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class OperateCustomerAddressesByIdList(customerId: Long, addressIds: List[Long], operation: String)(implicit
    val apiConfig: ApiConfig
) extends ApiRequest[Null, Null](
      None,
      None
    ) {
  override def method: Method = Method.PUT

  override def path: String =
    s"""/customers/$customerId/addresses/set.json?address_ids%5B%5D=${addressIds.mkString(",")}&operation=$operation"""

  override def body: Null = null
}
