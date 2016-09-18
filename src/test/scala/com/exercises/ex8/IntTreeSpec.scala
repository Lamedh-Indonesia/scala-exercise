package com.exercises.ex8

import org.scalatest.{ FunSpec, GivenWhenThen, Matchers, OneInstancePerTest }

class IntTreeSpec extends FunSpec with Matchers with GivenWhenThen with OneInstancePerTest {
  describe("IntTree") {

    Given("IntTree of 1,2 and 3")
    val tree = Node(2, Node(1, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

    it("should contains 1, 2 and 3") {
      List(1, 2, 3) foreach (IntTree.contains(tree, _) should be (true))
    }

    it("should not contains 0, 4 and 5") {
      List(0, 4, 5) foreach (IntTree.contains(tree, _) should be (false))
    }

    it("should contains 1, 2, 3, 0, 4 and 5 when inserted with associated values") {
      val tree0 = IntTree.insert(tree, 0)
      val tree04 = IntTree.insert(tree0, 4)
      val tree045 = IntTree.insert(tree04, 5)
      List(1, 2, 3, // original list
           0, 4, 5) foreach (IntTree.contains(tree045, _) should be (true))
    }
  }
}
