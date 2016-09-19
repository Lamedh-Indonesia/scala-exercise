package com.exercises.ex13ex14

import org.scalatest.Matchers
import org.scalatest.FunSpec

class UtilsSpec extends FunSpec with Matchers {
  describe("median") {

    import ToMedian._

    it("median of 1, 2 is 2") {
      List(1, 2).median should be (1.5)
    }

    it("median of 1, 2, 3 is 2") {
      List(1, 2, 3).median should be (2.0)
    }

    it("median of 1, 2, 3, 4 is 2") {
      List(1, 2, 3, 4).median should be (2.5)
    }

    it("median of 1 is 1") {
      List(1).median should be (1.0)
    }

    it("median of doubles 1, 2 is 2") {
      List(1.0, 2.0).median should be (1.5)
    }

    it("median of doubles 1, 2, 3 is 2") {
      List(1.0, 2.0, 3.0).median should be (2.0)
    }

    it("median of doubles 1, 2, 3, 4 is 2") {
      List(1.0, 2.0, 3.0, 4.0).median should be (2.5)
    }

    it("median of double 1 is 1") {
      List(1.0).median should be (1.0)
    }
  }
}
