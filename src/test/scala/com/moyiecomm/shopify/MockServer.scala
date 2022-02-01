package com.moyiecomm.shopify

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, Suite}
import com.github.tomakehurst.wiremock.client.WireMock._

trait MockServer extends BeforeAndAfterAll with BeforeAndAfterEach { self: Suite =>

  var wireMockServer: WireMockServer = _
  val port                           = 5089

  override def beforeEach(): Unit = {
    super.beforeEach()
    wireMockServer.resetAll()
  }

  override def afterEach(): Unit = {
    super.afterEach()
    wireMockServer.resetAll()
  }

  override def beforeAll(): Unit = {
    super.beforeAll()
    wireMockServer = new WireMockServer(options().port(port))
    wireMockServer.start()
    configureFor(port)
  }

  override def afterAll(): Unit = {
    super.afterAll()
    wireMockServer.stop()
  }
}
