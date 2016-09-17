package com.exercises.ex6

import scala.util.Try


object StringCommon extends App {
  def longest(words: String) = extractWords(words)(doLongest)
  def commonest(words: String) = extractWords(words)(doCommonest)

  def doLongest(words: Traversable[String]) =
    words.foldLeft(0)((max, w) => if (max < w.length) w.length else max)

  def doCommonest(words: Traversable[String]) = {
    val hist = words.foldLeft(Map[String, Int]())((map, w) => {
                                                    val n = Try(map(w)).getOrElse(0)
                                                    map + (w -> (n + 1))
                                                  })
    val maxKv = hist.foldLeft(("", 0))((max , kv) => if (max._2 < kv._2) kv else max)
    maxKv._1
  }

  def extractWords[A](words: String)(f: Traversable[String] => A): A = f(words.split(" "))

  println(commonest("damn yo damn yo yo"))
}
