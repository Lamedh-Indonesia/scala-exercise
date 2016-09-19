package com.exercises.ex13ex14

import scala.language.implicitConversions
import com.exercises.ex9ex10ex11.Utils

class VectorOfNumbers(numbers: Seq[Int]) {
  lazy val x = Utils.squareListMap(numbers)
  lazy val y = x.foldLeft(0)(_ + _)
  lazy val z = Math.sqrt(y)
}

trait Monoid[A] {
  def zero: A
  def op: (A, A) => A
}

class Median[A](val numbers: Seq[A], f: A => Double)(implicit m: Monoid[A]) {
  def median = {
    val middle = numbers.length / 2
    if ((numbers.length & 1) == 1) f(numbers(middle))
    else f(m.op(numbers(middle - 1), numbers(middle))) / 2
  }
}

object ToMedian {
  implicit val intAdditionMonoid = new Monoid[Int] {
    def zero = 0
    def op = _ + _
  }

  implicit val doubleAdditionMonoid = new Monoid[Double] {
    def zero = 0.0
    def op = _ + _
  }

  implicit def intsToMedian(numbers: Seq[Int]) = new Median[Int](numbers, _.toDouble)
  implicit def doublesToMedian(numbers: Seq[Double]) = new Median[Double](numbers, n => n)
}
