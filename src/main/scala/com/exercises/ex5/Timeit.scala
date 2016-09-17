package com.exercises.ex5

import scala.annotation.tailrec

object timeit {
  def apply[A](expression: => A): A = {
    println("Start warming up..")
    (1 to 10) foreach (_ => expression)
    println("End warming up..")

    val start = System.currentTimeMillis()
    val result = expression
    val end = System.currentTimeMillis()
    val millis = end - start
    println(s"The code takes $millis ms to execute")

    result
  }
}

// object TimeitApp extends App {
object TimeitApp {

  val n = timeit {
    (1 to 5000).foldLeft (0)(_ + _)
  }

  println(s"The result is $n")
}
