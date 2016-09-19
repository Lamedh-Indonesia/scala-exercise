package com.exercises.ex9ex10ex11

import scala.util.Try

object Utils {
  def squareList(list: List[Int]): List[Int] = list match {
    case List() => List()
    case x :: xs => (x * x) :: squareList(xs)
  }

  def squareListMap(list: Seq[Int]): Seq[Int] = list map (n => n * n)

  def firstNonEmpty[A](a: Option[A], b: Option[A], c: Option[A]) =
    a.getOrElse(b.getOrElse(c.getOrElse(None)))

  def listMapMultiply(list: List[Int], map: Map[Int, Double]) = {
    for {
      n <- list
      m <- List(Try(map(n)))
      if m.isSuccess
    } yield n * m.get
  }
}
