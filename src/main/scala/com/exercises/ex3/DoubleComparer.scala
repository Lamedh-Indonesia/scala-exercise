package com.exercises.ex3

class DoubleComparer(val self: Double) {
  def isEquals(other: Double)(implicit delta: Double = 0.1) = (self - other).abs <= delta
  def ~= (other: Double)(implicit delta: Double = 0.1) = isEquals(other)(delta)
}

object DoubleComparer {
  implicit def double2Comparer(value: Double): DoubleComparer = new DoubleComparer(value)
}
