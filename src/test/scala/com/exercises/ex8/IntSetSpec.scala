package com.exercises.ex8

import org.scalatest.{ FunSpec, GivenWhenThen, Matchers }

class IntSetSpec extends FunSpec with Matchers with GivenWhenThen {
  describe("IntSet") {
    it("EmptySet is empty, NonEmptySet is not empty") {
      EmptySet.isEmpty should be (true)
      new NonEmptySet(0, EmptySet, EmptySet).isEmpty should be (false)
    }

    Given("IntSet of (1, 2, 3, 4)")
    val set = EmptySet.incl(1).incl(2).incl(3).incl(4)

    it("contains 1, 2, 3, and 4") {
      List(1, 2, 3, 4) foreach (set.contains(_) should be (true))
    }

    it("doesn't contain 0, 5, 6") {
      List(0, 5, 6) foreach (set.contains(_) should be (false))
    }

    it("contain 1, 2, 3, 4, 0, 5, and 6 if it is united with another set") {
      val otherSet = EmptySet.incl(0).incl(5).incl(6)
      val union = set union otherSet
      List(1, 2, 3, 4, 0, 5, 6) foreach (union contains(_) should be (true))
      List(-1, 7, 8) foreach (set.contains(_) should be (false))
    }

    it("won't contain 3 and still contains 1,2,4 if 3 is excluded") {
      val excluded = set excl 3
      excluded contains(3) should be (false)
      List(1, 2, 4) foreach (excluded contains(_) should be (true))
    }

    it("has an intersection of 3 and 4 if intersected with (3,4,5) set") {
      val otherSet = EmptySet.incl(3).incl(4).incl(5)
      val intersected = set intersect otherSet
      List(3, 4) foreach (intersected contains(_) should be (true))
      List(1,2,5) foreach (intersected contains(_) should be (false))
    }
  }
}
