package com.exercises.ex2

import com.exercises.ex1.MutableQueue

trait ReversifQueue extends MutableQueue[String] {
  abstract override def put(string: String): Unit = {
    super.put(string.reverse)
  }
}
