package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class OperateCustomerAddressesByIdList(customerId: Long, addressIds: List[Long], operation: String)(implicit
    val apiConfig: ApiConfig
) extends ApiRequest[Null, Null, Errors](
      None,
      None,
      errorsDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String =
    s"""/customers/$customerId/addresses/set.json?address_ids%5B%5D=${addressIds.mkString(",")}&operation=$operation"""

  override def body: Null = null
}
