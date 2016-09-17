package com.exercises.ex3

import org.scalatest.{FunSpec, Matchers}

class DoubleCompareSpec extends FunSpec with Matchers {
  describe("Double comparer") {
    it("has a method similar to double's default '=='") {
      val double = new DoubleComparer(5.0)
      (double ~= 5.0)  should be (true)
    }

    it("compare based on delta") {
      val comparer = new DoubleComparer(5.0)
      comparer.isEquals(5.3)(0.5) should be (true)
      comparer.isEquals(5.3)(0.1) should be (false)
    }

    it("delta could be declared implicitly") {
      implicit val delta = 0.5
      val comparer = new DoubleComparer(5.0)
      comparer.isEquals(5.6) should be (false)
      comparer.isEquals(5.5) should be (true)
    }

    it("can compare double numbers using special syntax") {
      import DoubleComparer._
      val d: Double = 5.0

      (5.0 ~= 5.0) should be (true)

      implicit val delta = 0.5
      (5.0 ~= 5.5) should be (true)
      (5.0 ~= 5.6) should be (false)
    }
  }
}
