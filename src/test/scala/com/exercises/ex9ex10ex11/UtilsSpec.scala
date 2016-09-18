package com.exercises.ex9ex10ex11

import org.scalatest.{ FunSpec, GivenWhenThen, Matchers, OneInstancePerTest }

class UtilsSpec extends FunSpec with Matchers with GivenWhenThen with OneInstancePerTest {
  describe("SquareList of 1, 2, 3, 4") {

    val list = List(1, 2, 3, 4)

    it("squared with pattern, list is 1, 4, 9, 16") {
      Utils.squareList(list) should be (List(1, 4, 9, 16))
    }

    it("squared with map, list is 1, 4, 9, 16") {
      Utils.squareListMap(list) should be (List(1, 4, 9, 16))
    }
  }

  describe("First non null") {
    it("1, 2, 3 should be 1") {
      Utils.firstNonEmpty(Some(1), Some(2), Some(3)) should be (1)
    }

    it("None, 2, 3 should be 2") {
      Utils.firstNonEmpty(None, Some(2), Some(3)) should be (2)
    }

    it("None, None, 3 should be 3") {
      Utils.firstNonEmpty(None, None, Some(3)) should be (3)
    }

    it("None, None, None should be None") {
      Utils.firstNonEmpty(None, None, None) should be (None)
    }
  }

  describe("map and list multiplier") {
    it("list of (1, 2, 3, 4) and (1->3, 3->5) multiplication is (3, 15)") {
      Utils.listMapMultiply(List(1, 2, 3, 4), Map(1 -> 3, 3 -> 5)) should be (List(3, 15))
    }
  }
}
