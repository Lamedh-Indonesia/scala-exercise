package com.exercises.ex1

import org.scalatest.{FunSpec, GivenWhenThen, Matchers, OneInstancePerTest}

class MutableQueueSpec extends FunSpec
    with GivenWhenThen with Matchers with OneInstancePerTest {
  describe("empty MutableQueueArray") {

    val queue = new MutableQueueArray[String]()

    it("implement MutableQueue trait") {
      queue shouldBe a [MutableQueue[String]]
    }

    it("get from empty queue should return None") {
      queue.get() should be (None)
    }

    it("adding an item will make the size to 1") {
      val size0 = queue.length
      queue.put("one")
      queue.length should be (size0 + 1)
    }
  }

  describe("MutableQueueArray") {
    Given("Queue with two items")
    val queue = new MutableQueueArray[String]()
    queue.put("one")
    queue.put("two")

    it("adding an item will increment the size to 3") {
      queue.put("three")
      queue.length should be (3)
    }

    it("getting an item will decrement the size to 2") {
      queue.get()
      queue.length should be (1)
    }

    it("getting an item will get 'one'") {
      queue.get() should be (Some("one"))
    }

    it("getting an item twice, last one should be 'two'") {
      queue.get(); queue.get() should be (Some("two"))
    }

    it("getting an item three times, last one should be None") {
      queue.get(); queue.get(); queue.get() should be (None)
    }
  }
}

