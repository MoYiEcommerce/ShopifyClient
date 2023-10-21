package com.moyiecomm.shopify.api.v1.salesChannels

import com.moyiecomm.shopify.api.v1.orders.models.Transaction
import com.moyiecomm.shopify.api.v1.salesChannels.Payment._

case class Payment(
    creditCard: CreditCard,
    id: Long,
    paymentProcessingErrorMessage: String,
    nextAction: NextAction,
    transaction: Transaction,
    uniqueToken: String
)

object Payment {
  case class CreditCard()
  case class NextAction()
}
