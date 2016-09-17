package com.exercises.ex4ex5

import scala.annotation.tailrec

object Gcd {
  @tailrec
  def gcd(a: Int, b: Int): Int = {
    a % b match {
      case 0 => b
      case m => gcd(b, m)
    }
  }
}
