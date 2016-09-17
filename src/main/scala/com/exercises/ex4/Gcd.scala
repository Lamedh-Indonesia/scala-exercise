package com.exercises.ex4

import scala.annotation.tailrec

// object Gcd extends App {
object Gcd {
  @tailrec
  def gcd(a: Int, b: Int): Int = {
    a % b match {
      case 0 => b
      case m => gcd(b, m)
    }
  }

  println(gcd(468, 24))
}
