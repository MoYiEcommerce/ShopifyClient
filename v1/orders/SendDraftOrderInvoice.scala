package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.DraftOrderInvoice
import com.moyiecomm.shopify.api.v1.orders.models.DraftOrderInvoice.{draftOrderInvoiceDecoder, draftOrderInvoiceEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class SendDraftOrderInvoice(draftOrderId: Long, draftOrderInvoice: DraftOrderInvoice)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[DraftOrderInvoice, DraftOrderInvoice](draftOrderInvoice)(
      draftOrderInvoiceEncoder,
      draftOrderInvoiceDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = s"/draft_orders/$draftOrderId/send_invoice.json"
}
