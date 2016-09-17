package com.exercises.ex6

import scala.util.Try


object StringCommon extends App {

  object FromString {
    def longest(words: String) = extractWords(words)(FromTraversable.longest)
    def commonestWord(words: String) = extractWords(words)(FromTraversable.commonestWord)
    def commonestLetter(words: String) = extractWords(words)(FromTraversable.commonestLetter)
  }

  object FromTraversable {
    def longest(words: Traversable[String]) =
      words.foldLeft(0)((max, w) => if (max < w.length) w.length else max)

    def commonestWord(words: Traversable[String]) = commonestItem("")(words)

    def commonestLetter(words: Traversable[String]) =
      commonestItem(' ')(words.flatMap(w => w.map(c => c)))
  }

  def commonestItem[E](zero: E)(items: Traversable[E]) = {
    val hist = items.foldLeft(Map[E, Int]())((map, w) => {
                                               val n = Try(map(w)).getOrElse(0)
                                               map + (w -> (n + 1))
                                             })
    val maxKv = hist.foldLeft(zero -> 0)((max , kv) => if (max._2 < kv._2) kv else max)
    maxKv._1
  }

  def extractWords[A](words: String)(f: Traversable[String] => A): A = f(words.split(" "))
}
