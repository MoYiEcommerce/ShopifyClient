package com.moyiecomm.shopify

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock._
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import org.scalatest.BeforeAndAfterAll
import org.scalatest.BeforeAndAfterEach
import org.scalatest.Suite

trait MockServer extends BeforeAndAfterAll with BeforeAndAfterEach { self: Suite =>

  val port                           = 5089
  val wireMockServer: WireMockServer = new WireMockServer(options().port(port))

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
    wireMockServer.start()
    configureFor(port)
  }

  override def afterAll(): Unit = {
    super.afterAll()
    wireMockServer.stop()
  }
}
