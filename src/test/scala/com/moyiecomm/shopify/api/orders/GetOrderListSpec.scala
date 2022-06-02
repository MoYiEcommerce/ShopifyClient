package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.orders.models.{Order, Refund, Transaction}
import com.moyiecomm.shopify.api.shared.models.{
  AmountSet,
  ClientDetails,
  DiscountApplication,
  LineItem,
  NoteAttribute,
  PaymentDetail,
  Price,
  Receipt,
  RefundLineItem,
  ShippingLine,
  TaxLine
}
import com.moyiecomm.shopify.api.shippingFulfillment.Fulfillment
import sttp.model.{Method, StatusCode}

class GetOrderListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetOrderList(None, None, None, None, List.empty, Some(1), None, None, None),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders.json?limit=1",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders.json?limit=1")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "orders": [
              |    {
              |      "id": 450789469,
              |      "admin_graphql_api_id": "gid://shopify/Order/450789469",
              |      "app_id": null,
              |      "browser_ip": "0.0.0.0",
              |      "buyer_accepts_marketing": false,
              |      "cancel_reason": null,
              |      "cancelled_at": null,
              |      "cart_token": "68778783ad298f1c80c3bafcddeea02f",
              |      "checkout_id": 901414060,
              |      "checkout_token": "bd5a8aa1ecd019dd3520ff791ee3a24c",
              |      "client_details": {
              |        "accept_language": null,
              |        "browser_height": null,
              |        "browser_ip": "0.0.0.0",
              |        "browser_width": null,
              |        "session_hash": null,
              |        "user_agent": null
              |      },
              |      "closed_at": null,
              |      "confirmed": true,
              |      "contact_email": "bob.norman@mail.example.com",
              |      "created_at": "2008-01-10T11:00:00-05:00",
              |      "currency": "USD",
              |      "customer_locale": null,
              |      "device_id": null,
              |      "discount_codes": [
              |        {
              |          "code": "TENOFF",
              |          "amount": "10.00",
              |          "type": "fixed_amount"
              |        }
              |      ],
              |      "email": "bob.norman@mail.example.com",
              |      "financial_status": "partially_refunded",
              |      "fulfillment_status": null,
              |      "gateway": "authorize_net",
              |      "landing_site": "http://www.example.com?source=abc",
              |      "landing_site_ref": "abc",
              |      "location_id": null,
              |      "name": "#1001",
              |      "note": null,
              |      "note_attributes": [
              |        {
              |          "name": "custom engraving",
              |          "value": "Happy Birthday"
              |        },
              |        {
              |          "name": "colour",
              |          "value": "green"
              |        }
              |      ],
              |      "number": 1,
              |      "order_number": 1001,
              |      "order_status_url": "https://jsmith.myshopify.com/548380009/orders/b1946ac92492d2347c6235b4d2611184/authenticate?key=imasecretipod",
              |      "payment_gateway_names": [
              |        "bogus"
              |      ],
              |      "phone": "+557734881234",
              |      "presentment_currency": "USD",
              |      "processed_at": "2008-01-10T11:00:00-05:00",
              |      "processing_method": "direct",
              |      "reference": "fhwdgads",
              |      "referring_site": "http://www.otherexample.com",
              |      "source_identifier": "fhwdgads",
              |      "source_name": "web",
              |      "source_url": null,
              |      "subtotal_price": "597.00",
              |      "subtotal_price_set": {
              |        "shop_money": {
              |          "amount": "597.00",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "597.00",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "tags": "",
              |      "tax_lines": [
              |        {
              |          "price": "11.94",
              |          "rate": 0.06,
              |          "title": "State Tax",
              |          "price_set": {
              |            "shop_money": {
              |              "amount": "11.94",
              |              "currency_code": "USD"
              |            },
              |            "presentment_money": {
              |              "amount": "11.94",
              |              "currency_code": "USD"
              |            }
              |          }
              |        }
              |      ],
              |      "taxes_included": false,
              |      "test": false,
              |      "token": "b1946ac92492d2347c6235b4d2611184",
              |      "total_discounts": "10.00",
              |      "total_discounts_set": {
              |        "shop_money": {
              |          "amount": "10.00",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "10.00",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "total_line_items_price": "597.00",
              |      "total_line_items_price_set": {
              |        "shop_money": {
              |          "amount": "597.00",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "597.00",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "total_price": "598.94",
              |      "total_price_set": {
              |        "shop_money": {
              |          "amount": "598.94",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "598.94",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "total_price_usd": "598.94",
              |      "total_shipping_price_set": {
              |        "shop_money": {
              |          "amount": "0.00",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "0.00",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "total_tax": "11.94",
              |      "total_tax_set": {
              |        "shop_money": {
              |          "amount": "11.94",
              |          "currency_code": "USD"
              |        },
              |        "presentment_money": {
              |          "amount": "11.94",
              |          "currency_code": "USD"
              |        }
              |      },
              |      "total_tip_received": "0.00",
              |      "total_weight": 0,
              |      "updated_at": "2008-01-10T11:00:00-05:00",
              |      "user_id": null,
              |      "billing_address": {
              |        "first_name": "Bob",
              |        "address1": "Chestnut Street 92",
              |        "phone": "555-625-1199",
              |        "city": "Louisville",
              |        "zip": "40202",
              |        "province": "Kentucky",
              |        "country": "United States",
              |        "last_name": "Norman",
              |        "address2": "",
              |        "company": null,
              |        "latitude": 45.41634,
              |        "longitude": -75.6868,
              |        "name": "Bob Norman",
              |        "country_code": "US",
              |        "province_code": "KY"
              |      },
              |      "customer": {
              |        "id": 207119551,
              |        "email": "bob.norman@mail.example.com",
              |        "accepts_marketing": false,
              |        "created_at": "2022-04-05T13:05:24-04:00",
              |        "updated_at": "2022-04-05T13:05:24-04:00",
              |        "first_name": "Bob",
              |        "last_name": "Norman",
              |        "orders_count": 1,
              |        "state": "disabled",
              |        "total_spent": "199.65",
              |        "last_order_id": 450789469,
              |        "note": null,
              |        "verified_email": true,
              |        "multipass_identifier": null,
              |        "tax_exempt": false,
              |        "phone": "+16136120707",
              |        "tags": "",
              |        "last_order_name": "#1001",
              |        "currency": "USD",
              |        "accepts_marketing_updated_at": "2005-06-12T11:57:11-04:00",
              |        "marketing_opt_in_level": null,
              |        "tax_exemptions": [],
              |        "admin_graphql_api_id": "gid://shopify/Customer/207119551",
              |        "default_address": {
              |          "id": 207119551,
              |          "customer_id": 207119551,
              |          "first_name": null,
              |          "last_name": null,
              |          "company": null,
              |          "address1": "Chestnut Street 92",
              |          "address2": "",
              |          "city": "Louisville",
              |          "province": "Kentucky",
              |          "country": "United States",
              |          "zip": "40202",
              |          "phone": "555-625-1199",
              |          "name": "",
              |          "province_code": "KY",
              |          "country_code": "US",
              |          "country_name": "United States",
              |          "default": true
              |        }
              |      },
              |      "discount_applications": [
              |        {
              |          "target_type": "line_item",
              |          "type": "discount_code",
              |          "value": "10.0",
              |          "value_type": "fixed_amount",
              |          "allocation_method": "across",
              |          "target_selection": "all",
              |          "code": "TENOFF"
              |        }
              |      ],
              |      "fulfillments": [
              |        {
              |          "id": 255858046,
              |          "admin_graphql_api_id": "gid://shopify/Fulfillment/255858046",
              |          "created_at": "2022-04-05T13:05:24-04:00",
              |          "location_id": 655441491,
              |          "name": "#1001.0",
              |          "order_id": 450789469,
              |          "receipt": {
              |            "testcase": true,
              |            "authorization": "123456"
              |          },
              |          "service": "manual",
              |          "shipment_status": null,
              |          "status": "failure",
              |          "tracking_company": "USPS",
              |          "tracking_number": "1Z2345",
              |          "tracking_numbers": [
              |            "1Z2345"
              |          ],
              |          "tracking_url": "https://tools.usps.com/go/TrackConfirmAction_input?qtc_tLabels1=1Z2345",
              |          "tracking_urls": [
              |            "https://tools.usps.com/go/TrackConfirmAction_input?qtc_tLabels1=1Z2345"
              |          ],
              |          "updated_at": "2022-04-05T13:05:24-04:00",
              |          "line_items": [
              |            {
              |              "id": 466157049,
              |              "admin_graphql_api_id": "gid://shopify/LineItem/466157049",
              |              "fulfillable_quantity": 0,
              |              "fulfillment_service": "manual",
              |              "fulfillment_status": null,
              |              "gift_card": false,
              |              "grams": 200,
              |              "name": "IPod Nano - 8gb - green",
              |              "price": "199.00",
              |              "price_set": {
              |                "shop_money": {
              |                  "amount": "199.00",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "199.00",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "product_exists": true,
              |              "product_id": 632910392,
              |              "properties": [
              |                {
              |                  "name": "Custom Engraving Front",
              |                  "value": "Happy Birthday"
              |                },
              |                {
              |                  "name": "Happy Birthday",
              |                  "value": "Merry Christmas"
              |                }
              |              ],
              |              "quantity": 1,
              |              "requires_shipping": true,
              |              "sku": "IPOD2008GREEN",
              |              "taxable": true,
              |              "title": "IPod Nano - 8gb",
              |              "total_discount": "0.00",
              |              "total_discount_set": {
              |                "shop_money": {
              |                  "amount": "0.00",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "0.00",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "variant_id": 39072856,
              |              "variant_inventory_management": "shopify",
              |              "variant_title": "green",
              |              "vendor": null,
              |              "tax_lines": [
              |                {
              |                  "price": "3.98",
              |                  "price_set": {
              |                    "shop_money": {
              |                      "amount": "3.98",
              |                      "currency_code": "USD"
              |                    },
              |                    "presentment_money": {
              |                      "amount": "3.98",
              |                      "currency_code": "USD"
              |                    }
              |                  },
              |                  "rate": 0.06,
              |                  "title": "State Tax"
              |                }
              |              ],
              |              "discount_allocations": [
              |                {
              |                  "amount": "3.34",
              |                  "amount_set": {
              |                    "shop_money": {
              |                      "amount": "3.34",
              |                      "currency_code": "USD"
              |                    },
              |                    "presentment_money": {
              |                      "amount": "3.34",
              |                      "currency_code": "USD"
              |                    }
              |                  },
              |                  "discount_application_index": 0
              |                }
              |              ]
              |            }
              |          ]
              |        }
              |      ],
              |      "line_items": [
              |        {
              |          "id": 466157049,
              |          "admin_graphql_api_id": "gid://shopify/LineItem/466157049",
              |          "fulfillable_quantity": 0,
              |          "fulfillment_service": "manual",
              |          "fulfillment_status": null,
              |          "gift_card": false,
              |          "grams": 200,
              |          "name": "IPod Nano - 8gb - green",
              |          "price": "199.00",
              |          "price_set": {
              |            "shop_money": {
              |              "amount": "199.00",
              |              "currency_code": "USD"
              |            },
              |            "presentment_money": {
              |              "amount": "199.00",
              |              "currency_code": "USD"
              |            }
              |          },
              |          "product_exists": true,
              |          "product_id": 632910392,
              |          "properties": [
              |            {
              |              "name": "Custom Engraving Front",
              |              "value": "Happy Birthday"
              |            },
              |            {
              |              "name": "Custom Engraving Back",
              |              "value": "Merry Christmas"
              |            }
              |          ],
              |          "quantity": 1,
              |          "requires_shipping": true,
              |          "sku": "IPOD2008GREEN",
              |          "taxable": true,
              |          "title": "IPod Nano - 8gb",
              |          "total_discount": "0.00",
              |          "total_discount_set": {
              |            "shop_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            },
              |            "presentment_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            }
              |          },
              |          "variant_id": 39072856,
              |          "variant_inventory_management": "shopify",
              |          "variant_title": "green",
              |          "vendor": null,
              |          "tax_lines": [
              |            {
              |              "price": "3.98",
              |              "price_set": {
              |                "shop_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "rate": 0.06,
              |              "title": "State Tax"
              |            }
              |          ],
              |          "discount_allocations": [
              |            {
              |              "amount": "3.34",
              |              "amount_set": {
              |                "shop_money": {
              |                  "amount": "3.34",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "3.34",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "discount_application_index": 0
              |            }
              |          ]
              |        }
              |      ],
              |      "payment_details": {
              |        "credit_card_bin": null,
              |        "avs_result_code": null,
              |        "cvv_result_code": null,
              |        "credit_card_number": "•••• •••• •••• 4242",
              |        "credit_card_company": "Visa"
              |      },
              |      "refunds": [
              |        {
              |          "id": 509562969,
              |          "admin_graphql_api_id": "gid://shopify/Refund/509562969",
              |          "created_at": "2022-04-05T13:05:24-04:00",
              |          "note": "it broke during shipping",
              |          "order_id": 450789469,
              |          "processed_at": "2022-04-05T13:05:24-04:00",
              |          "restock": true,
              |          "user_id": 548380009,
              |          "order_adjustments": [],
              |          "transactions": [
              |            {
              |              "id": 179259969,
              |              "admin_graphql_api_id": "gid://shopify/OrderTransaction/179259969",
              |              "amount": "209.00",
              |              "authorization": "authorization-key",
              |              "created_at": "2005-08-05T12:59:12-04:00",
              |              "currency": "USD",
              |              "device_id": null,
              |              "error_code": null,
              |              "gateway": "bogus",
              |              "kind": "refund",
              |              "location_id": null,
              |              "message": null,
              |              "order_id": 450789469,
              |              "parent_id": 801038806,
              |              "processed_at": "2005-08-05T12:59:12-04:00",
              |              "receipt": {},
              |              "source_name": "web",
              |              "status": "success",
              |              "test": false,
              |              "user_id": null
              |            }
              |          ],
              |          "refund_line_items": [
              |            {
              |              "id": 104689539,
              |              "line_item_id": 703073504,
              |              "location_id": 487838322,
              |              "quantity": 1,
              |              "restock_type": "legacy_restock",
              |              "subtotal": 195.66,
              |              "subtotal_set": {
              |                "shop_money": {
              |                  "amount": "195.66",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "195.66",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "total_tax": 3.98,
              |              "total_tax_set": {
              |                "shop_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "line_item": {
              |                "id": 703073504,
              |                "admin_graphql_api_id": "gid://shopify/LineItem/703073504",
              |                "fulfillable_quantity": 0,
              |                "fulfillment_service": "manual",
              |                "fulfillment_status": null,
              |                "gift_card": false,
              |                "grams": 200,
              |                "name": "IPod Nano - 8gb - black",
              |                "price": "199.00",
              |                "price_set": {
              |                  "shop_money": {
              |                    "amount": "199.00",
              |                    "currency_code": "USD"
              |                  },
              |                  "presentment_money": {
              |                    "amount": "199.00",
              |                    "currency_code": "USD"
              |                  }
              |                },
              |                "product_exists": true,
              |                "product_id": 632910392,
              |                "properties": [],
              |                "quantity": 1,
              |                "requires_shipping": true,
              |                "sku": "IPOD2008BLACK",
              |                "taxable": true,
              |                "title": "IPod Nano - 8gb",
              |                "total_discount": "0.00",
              |                "total_discount_set": {
              |                  "shop_money": {
              |                    "amount": "0.00",
              |                    "currency_code": "USD"
              |                  },
              |                  "presentment_money": {
              |                    "amount": "0.00",
              |                    "currency_code": "USD"
              |                  }
              |                },
              |                "variant_id": 457924702,
              |                "variant_inventory_management": "shopify",
              |                "variant_title": "black",
              |                "vendor": null,
              |                "tax_lines": [
              |                  {
              |                    "price": "3.98",
              |                    "price_set": {
              |                      "shop_money": {
              |                        "amount": "3.98",
              |                        "currency_code": "USD"
              |                      },
              |                      "presentment_money": {
              |                        "amount": "3.98",
              |                        "currency_code": "USD"
              |                      }
              |                    },
              |                    "rate": 0.06,
              |                    "title": "State TapaymentTermsx"
              |                  }
              |                ],
              |                "discount_allocations": [
              |                  {
              |                    "amount": "3.33",
              |                    "amount_set": {
              |                      "shop_money": {
              |                        "amount": "3.33",
              |                        "currency_code": "USD"
              |                      },
              |                      "presentment_money": {
              |                        "amount": "3.33",
              |                        "currency_code": "USD"
              |                      }
              |                    },
              |                    "discount_application_index": 0
              |                  }
              |                ]
              |              }
              |            },
              |            {
              |              "id": 709875399,
              |              "line_item_id": 466157049,
              |              "location_id": 487838322,
              |              "quantity": 1,
              |              "restock_type": "legacy_restock",
              |              "subtotal": 195.67,
              |              "subtotal_set": {
              |                "shop_money": {
              |                  "amount": "195.67",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "195.67",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "total_tax": 3.98,
              |              "total_tax_set": {
              |                "shop_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                },
              |                "presentment_money": {
              |                  "amount": "3.98",
              |                  "currency_code": "USD"
              |                }
              |              },
              |              "line_item": {
              |                "id": 466157049,
              |                "admin_graphql_api_id": "gid://shopify/LineItem/466157049",
              |                "fulfillable_quantity": 0,
              |                "fulfillment_service": "manual",
              |                "fulfillment_status": null,
              |                "gift_card": false,
              |                "grams": 200,
              |                "name": "IPod Nano - 8gb - green",
              |                "price": "199.00",
              |                "price_set": {
              |                  "shop_money": {
              |                    "amount": "199.00",
              |                    "currency_code": "USD"
              |                  },
              |                  "presentment_money": {
              |                    "amount": "199.00",
              |                    "currency_code": "USD"
              |                  }
              |                },
              |                "product_exists": true,
              |                "product_id": 632910392,
              |                "properties": [
              |                  {
              |                    "name": "Custom Engraving Front",
              |                    "value": "Happy Birthday"
              |                  },
              |                  {
              |                    "name": "Custom Engraving Back",
              |                    "value": "Merry Christmas"
              |                  }
              |                ],
              |                "quantity": 1,
              |                "requires_shipping": true,
              |                "sku": "IPOD2008GREEN",
              |                "taxable": true,
              |                "title": "IPod Nano - 8gb",
              |                "total_discount": "0.00",
              |                "total_discount_set": {
              |                  "shop_money": {
              |                    "amount": "0.00",
              |                    "currency_code": "USD"
              |                  },
              |                  "presentment_money": {
              |                    "amount": "0.00",
              |                    "currency_code": "USD"
              |                  }
              |                },
              |                "variant_id": 39072856,
              |                "variant_inventory_management": "shopify",
              |                "variant_title": "green",
              |                "vendor": null,
              |                "tax_lines": [
              |                  {
              |                    "price": "3.98",
              |                    "price_set": {
              |                      "shop_money": {
              |                        "amount": "3.98",
              |                        "currency_code": "USD"
              |                      },
              |                      "presentment_money": {
              |                        "amount": "3.98",
              |                        "currency_code": "USD"
              |                      }
              |                    },
              |                    "rate": 0.06,
              |                    "title": "State Tax"
              |                  }
              |                ],
              |                "discount_allocations": [
              |                  {
              |                    "amount": "3.34",
              |                    "amount_set": {
              |                      "shop_money": {
              |                        "amount": "3.34",
              |                        "currency_code": "USD"
              |                      },
              |                      "presentment_money": {
              |                        "amount": "3.34",
              |                        "currency_code": "USD"
              |                      }
              |                    },
              |                    "discount_application_index": 0
              |                  }
              |                ]
              |              }
              |            }
              |          ]
              |        }
              |      ],
              |      "shipping_address": {
              |        "first_name": "Bob",
              |        "address1": "Chestnut Street 92",
              |        "phone": "555-625-1199",
              |        "city": "Louisville",
              |        "zip": "40202",
              |        "province": "Kentucky",
              |        "country": "United States",
              |        "last_name": "Norman",
              |        "address2": "",
              |        "company": null,
              |        "latitude": 45.41634,
              |        "longitude": -75.6868,
              |        "name": "Bob Norman",
              |        "country_code": "US",
              |        "province_code": "KY"
              |      },
              |      "shipping_lines": [
              |        {
              |          "id": 369256396,
              |          "carrier_identifier": null,
              |          "code": "Free Shipping",
              |          "delivery_category": null,
              |          "discounted_price": "0.00",
              |          "discounted_price_set": {
              |            "shop_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            },
              |            "presentment_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            }
              |          },
              |          "phone": null,
              |          "price": "0.00",
              |          "price_set": {
              |            "shop_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            },
              |            "presentment_money": {
              |              "amount": "0.00",
              |              "currency_code": "USD"
              |            }
              |          },
              |          "requested_fulfillment_service_id": null,
              |          "source": "shopify",
              |          "title": "Free Shipping",
              |          "tax_lines": [],
              |          "discount_allocations": []
              |        }
              |      ]
              |    }
              |  ]
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      List(
        Order(
          id = Some(450789469),
          appId = None,
          browserIp = Some("0.0.0.0"),
          buyerAcceptsMarketing = Some(false),
          cancelReason = None,
          cancelledAt = None,
          cartToken = Some("68778783ad298f1c80c3bafcddeea02f"),
          clientDetails = Some(
            ClientDetails(
              acceptLanguage = None,
              browserHeight = None,
              browserIp = Some("0.0.0.0"),
              browserWidth = None,
              sessionHash = None,
              userAgent = None
            )
          ),
          closedAt = None,
          createdAt = "2008-01-10T11:00:00-05:00",
          currency = Some("USD"),
          currentSubtotalPrice = None,
          currentSubtotalPriceSet = None,
          currentTotalDiscounts = None,
          currentTotalDiscountsSet = None,
          currentTotalDutiesSet = None,
          currentTotalPrice = None,
          currentTotalPriceSet = None,
          currentTotalTax = None,
          currentTotalTaxSet = None,
          customerLocale = None,
          discountCodes = List(
            DiscountCode(
              id = None,
              code = "TENOFF",
              usageCount = None,
              amount = Some(10.00),
              `type` = Some("fixed_amount"),
              priceRuleId = None,
              createdAt = None,
              updatedAt = None
            )
          ),
          email = Some("bob.norman@mail.example.com"),
          estimatedTaxes = None,
          financialStatus = Some("partially_refunded"),
          fulfillmentStatus = None,
          landingSite = Some("http://www.example.com?source=abc"),
          locationId = None,
          name = Some("#1001"),
          note = None,
          noteAttributes = List(
            NoteAttribute("custom engraving", "Happy Birthday"),
            NoteAttribute("colour", "green")
          ),
          number = Some(1),
          orderNumber = Some(1001),
          orderStatusUrl = Some(
            "https://jsmith.myshopify.com/548380009/orders/b1946ac92492d2347c6235b4d2611184/authenticate?key=imasecretipod"
          ),
          originalTotalDutiesSet = None,
          phone = Some("+557734881234"),
          presentmentCurrency = Some("USD"),
          processedAt = "2008-01-10T11:00:00-05:00",
          processingMethod = Some("direct"),
          referringSite = Some("http://www.otherexample.com"),
          sourceName = Some("web"),
          subtotalPrice = Some("597.00"),
          subtotalPriceSet = Some(
            AmountSet(
              Price("597.00", "USD"),
              Price("597.00", "USD")
            )
          ),
          tags = Some(""),
          taxLines = List(
            TaxLine(price = 11.94, rate = 0.06, title = Some("State Tax"), channelLiable = None)
          ),
          taxesIncluded = Some(false),
          test = Some(false),
          token = Some("b1946ac92492d2347c6235b4d2611184"),
          totalDiscounts = Some("10.00"),
          totalDiscountsSet = Some(
            AmountSet(
              Price("10.00", "USD"),
              Price("10.00", "USD")
            )
          ),
          totalLineItemsPrice = Some("597.00"),
          totalLineItemsPriceSet = Some(
            AmountSet(
              Price("597.00", "USD"),
              Price("597.00", "USD")
            )
          ),
          totalPrice = Some("598.94"),
          totalPriceSet = Some(
            AmountSet(
              Price("598.94", "USD"),
              Price("598.94", "USD")
            )
          ),
          totalShippingPriceSet = Some(
            AmountSet(
              Price("0.00", "USD"),
              Price("0.00", "USD")
            )
          ),
          totalTax = Some("11.94"),
          totalTaxSet = Some(
            AmountSet(
              Price("11.94", "USD"),
              Price("11.94", "USD")
            )
          ),
          totalTipReceived = Some("0.00"),
          totalWeight = Some(0),
          updatedAt = "2008-01-10T11:00:00-05:00",
          userId = None,
          billingAddress = Some(
            Address(
              id = None,
              customerId = None,
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              province = "Kentucky",
              phone = "555-625-1199",
              zip = "40202",
              company = None,
              lastName = Some("Norman"),
              firstName = Some("Bob"),
              country = "United States",
              name = Some("Bob Norman"),
              provinceCode = Some("KY"),
              countryCode = Some("US"),
              countryName = None,
              latitude = Some(45.41634),
              longitude = Some(-75.6868),
              default = None
            )
          ),
          customer = Some(
            Customer(
              id = Some(207119551),
              firstName = "Bob",
              lastName = "Norman",
              email = "bob.norman@mail.example.com",
              phone = Some("+16136120707"),
              verifiedEmail = Some(true),
              acceptsMarketing = Some(false),
              acceptsMarketingUpdatedAt = "2005-06-12T11:57:11-04:00",
              addresses = List.empty,
              currency = Some("USD"),
              defaultAddress = Some(
                Address(
                  id = Some(207119551),
                  customerId = Some(207119551),
                  address1 = "Chestnut Street 92",
                  address2 = Some(""),
                  city = "Louisville",
                  province = "Kentucky",
                  phone = "555-625-1199",
                  zip = "40202",
                  company = None,
                  lastName = None,
                  firstName = None,
                  country = "United States",
                  name = Some(""),
                  provinceCode = Some("KY"),
                  countryCode = Some("US"),
                  countryName = Some("United States"),
                  latitude = None,
                  longitude = None,
                  default = Some(true)
                )
              ),
              lastOrderId = Some(450789469),
              lastOrderName = Some("#1001"),
              metafield = None,
              marketingOptInLevel = None,
              multipassIdentifier = None,
              note = None,
              ordersCount = Some(1),
              smsMarketingConsent = None,
              emailMarketingConsent = None,
              smsTransactionalConsent = None,
              state = Some("disabled"),
              tags = Some(""),
              taxExempt = Some(false),
              tax_exemptions = List.empty,
              totalSpent = Some(199.65),
              createdAt = "2022-04-05T13:05:24-04:00",
              updatedAt = "2022-04-05T13:05:24-04:00"
            )
          ),
          discountApplications = List(
            DiscountApplication(
              `type` = "discount_code",
              code = "TENOFF",
              value = 10.0,
              valueType = "fixed_amount",
              allocationMethod = "across",
              targetSelection = "all",
              targetType = "line_item"
            )
          ),
          fulfillments = List(
            Fulfillment(
              id = Some(255858046),
              orderId = Some(450789469),
              lineItems = List(
                LineItem(
                  id = Some(466157049),
                  custom = None,
                  name = Some("IPod Nano - 8gb - green"),
                  fulfillmentService = Some("manual"),
                  fulfillmentStatus = None,
                  grams = Some(200),
                  price = 199.00,
                  productId = Some(632910392),
                  quantity = 1,
                  requiresShipping = Some(true),
                  sku = Some("IPOD2008GREEN"),
                  title = Some("IPod Nano - 8gb"),
                  variantId = Some(39072856),
                  variantTitle = Some("green"),
                  vendor = None,
                  giftCard = Some(false),
                  properties = List(
                    NoteAttribute("Custom Engraving Front", "Happy Birthday"),
                    NoteAttribute("Happy Birthday", "Merry Christmas")
                  ),
                  appliedDiscount = None,
                  taxLines = List(
                    TaxLine(price = 3.98, rate = 0.06, title = Some("State Tax"), channelLiable = None)
                  ),
                  taxable = Some(true)
                )
              ),
              locationId = Some(655441491),
              name = Some("#1001.0"),
              notifyCustomer = None,
              originAddress = None,
              receipt = Some(Receipt(true, "123456")),
              service = Some("manual"),
              shipmentStatus = None,
              status = Some("failure"),
              trackingCompany = Some("USPS"),
              trackingNumbers = List("1Z2345"),
              trackingUrls = List("https://tools.usps.com/go/TrackConfirmAction_input?qtc_tLabels1=1Z2345"),
              variantInventoryManagement = None,
              createdAt = "2022-04-05T13:05:24-04:00",
              updatedAt = "2022-04-05T13:05:24-04:00"
            )
          ),
          lineItems = List(
            LineItem(
              id = Some(466157049),
              custom = None,
              name = Some("IPod Nano - 8gb - green"),
              fulfillmentService = Some("manual"),
              fulfillmentStatus = None,
              grams = Some(200),
              price = 199.00,
              productId = Some(632910392),
              quantity = 1,
              requiresShipping = Some(true),
              sku = Some("IPOD2008GREEN"),
              title = Some("IPod Nano - 8gb"),
              variantId = Some(39072856),
              variantTitle = Some("green"),
              vendor = None,
              giftCard = Some(false),
              properties = List(
                NoteAttribute("Custom Engraving Front", "Happy Birthday"),
                NoteAttribute("Custom Engraving Back", "Merry Christmas")
              ),
              appliedDiscount = None,
              taxLines = List(
                TaxLine(price = 3.98, rate = 0.06, title = Some("State Tax"), channelLiable = None)
              ),
              taxable = Some(true)
            )
          ),
          paymentDetails = Some(
            PaymentDetail(
              creditCardBin = None,
              avsResultCode = None,
              cvvResultCode = None,
              creditCardNumber = "•••• •••• •••• 4242",
              creditCardCompany = "Visa"
            )
          ),
          refunds = List(
            Refund(
              id = Some(509562969),
              orderId = Some(450789469),
              userId = Some(548380009),
              note = Some("it broke during shipping"),
              currency = None,
              restock = Some(true),
              shipping = None,
              duties = List.empty,
              orderAdjustments = List.empty,
              transactions = List(
                Transaction(
                  id = Some(179259969),
                  orderId = Some(450789469),
                  kind = Some("refund"),
                  gateway = Some("bogus"),
                  status = Some("success"),
                  message = None,
                  createdAt = "2005-08-05T12:59:12-04:00",
                  test = Some(false),
                  authorization = Some("authorization-key"),
                  locationId = None,
                  userId = None,
                  parentId = Some(801038806),
                  processedAt = "2005-08-05T12:59:12-04:00",
                  sourceName = Some("web"),
                  deviceId = None,
                  errorCode = None,
                  paymentDetails = None,
                  currencyExchangeAdjustment = None,
                  amount = Some("209.00"),
                  paymentsRefundAttributes = None,
                  currency = Some("USD"),
                  authorizationExpiresAt = None,
                  extendedAuthorizationAttributes = None,
                  maximumRefundable = None
                )
              ),
              refundDuties = List.empty,
              refundLineItems = List(
                RefundLineItem(
                  lineItemId = 703073504,
                  quantity = 1,
                  restockType = "legacy_restock",
                  locationId = Some(487838322)
                ),
                RefundLineItem(lineItemId = 466157049, quantity = 1, restockType = "legacy_restock", locationId = Some(487838322))
              ),
              createdAt = "2022-04-05T13:05:24-04:00",
              processedAt = "2022-04-05T13:05:24-04:00"
            )
          ),
          shippingAddress = Some(
            Address(
              id = None,
              customerId = None,
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              province = "Kentucky",
              phone = "555-625-1199",
              zip = "40202",
              company = None,
              lastName = Some("Norman"),
              firstName = Some("Bob"),
              country = "United States",
              name = Some("Bob Norman"),
              provinceCode = Some("KY"),
              countryCode = Some("US"),
              countryName = None,
              latitude = Some(45.41634),
              longitude = Some(-75.6868),
              default = None
            )
          ),
          shippingLines = List(
            ShippingLine(
              code = "Free Shipping",
              price = 0.00,
              source = "shopify",
              title = Some("Free Shipping")
            )
          ),
          paymentTerms = None
        )
      )
    )
  )
}
