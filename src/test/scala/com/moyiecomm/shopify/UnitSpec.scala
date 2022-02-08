package com.moyiecomm.shopify

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

abstract class UnitSpec extends AsyncFlatSpec with should.Matchers with OptionValues with Inside with Inspectors
