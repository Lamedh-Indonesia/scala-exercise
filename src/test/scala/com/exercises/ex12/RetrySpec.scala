package com.exercises.ex12

import org.scalatest.Matchers
import org.scalatest.FunSpec

class RetrySpec extends FunSpec with Matchers {
  describe("retry") {

    it("automatically retry 3 times its erratic enclosed expression block") {
      import com.exercises.ex12.implicits._

      var times = 0
      retry {
        times += 1
        throw new Exception("")
      }
      times should be (3)
    }

    it("has a custom option for customizing sleep and times") {
      implicit val opt = RetryOption(times = 2, sleep = 10)

      var times = 0
      retry {
        times += 1
        throw new Exception("")
      }
      times should be (2)
    }
  }
}
