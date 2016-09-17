package com.exercises.ex4ex5

import scala.annotation.tailrec

object timeit {
  def apply[A](expression: => A): A = {
    println("Start warming up..")
    (1 to 10) foreach (_ => expression)
    println("End warming up..")

    val start = System.currentTimeMillis()
    val result = expression
    val millis = System.currentTimeMillis() - start
    println(s"The code takes $millis ms to execute")

    result
  }
}
