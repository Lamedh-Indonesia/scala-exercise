package com.exercises.ex8

abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

object IntTree {
  def contains(tree: IntTree, value: Int): Boolean = tree match {
    case EmptyTree => false
    case Node(e, left, right) =>
      if (e == value) true
      else contains(left, value) || contains(right, value)
  }

  def insert(tree: IntTree, value: Int): IntTree = tree match {
    case EmptyTree => Node(value, EmptyTree, EmptyTree)
    case Node(v, l, r) => if (v < value) Node(v, insert(l, value), r)
                          else Node(v, l, insert(r, value))
  }
}
