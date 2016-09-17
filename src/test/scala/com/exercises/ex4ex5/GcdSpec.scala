package com.exercises.ex4ex5

import org.scalatest.{FunSpec, Matchers}

class Gcd_and_timeit_spec extends FunSpec with Matchers {
  describe("GCD") {
    it("GCD of 468 and 24 is 12") {
      Gcd.gcd(468, 24) should be (12)
    }
  }

  describe("timeit") {
    it ("can still get the result while printing the time") {
      val n = timeit {
        (1 to 5000).foldLeft (0)(_ + _)
      }
      println(s"The result is $n")
    }
  }
}
