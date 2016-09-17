package com.exercises.ex2

import com.exercises.ex1.MutableQueueArray
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class ReversifQueueSpec extends FunSpec with Matchers with GivenWhenThen {
  describe("Reversing queue") {
    val queue = new MutableQueueArray[String]() with ReversifQueue

    When("added with 'one'")
    queue.put("one")

    it("get will obtain 'eno''") {
      queue.get should be (Some("eno"))
    }
  }
}
