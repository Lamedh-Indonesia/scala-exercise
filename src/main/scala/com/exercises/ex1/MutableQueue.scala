package com.exercises.ex1

trait MutableQueue[A] {
  def get(): Option[A]
  def put(item: A): Unit
  def length: Int
}

class MutableQueueArray[A: ClassManifest] extends MutableQueue[A] {
  private var enterIndex = 0
  private var outIndex = 0
  private val elements = new Array[A](100)

  def get() = {
    if (length == 0) None
    else {
      val elem = elements(outIndex)
      outIndex += 1
      Some(elem)
    }
  }

  def put(item: A) = {
    elements(enterIndex) = item
    enterIndex += 1
  }

  def length = enterIndex - outIndex
}
