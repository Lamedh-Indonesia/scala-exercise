package com.exercises.ex12

import scala.util.{ Failure, Success, Try }

case class RetryOption(times: Int, sleep: Int)

object implicits {
  implicit val retryOption = RetryOption(times = 3, sleep = 0)
}

object retry {
  def apply[A](exp: => A)(implicit option: RetryOption) =
    doApply(exp, option.times, option.sleep,
            Failure(new Exception("exp hasn't been called")))

  def doApply[A](exp: => A, times: Int, sleep: Int, trial: Try[A]): Try[A] = {
    if (times <= 0) trial
    else {
      val result = Try(exp)
      result match {
        case Success(_) => result
        case t: Failure[A] => {
          if (sleep > 0) Thread.sleep(sleep)
          doApply(exp, times - 1, sleep, t)}
      }
    }
  }
}
