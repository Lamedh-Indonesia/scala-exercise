package com.exercises.ex6

import scala.util.Try

object StringCommon {

  def longest(words: String) = (splitWords _ andThen FromArray.longest _)(words)
  def commonestWord(words: String) = (splitWords _ andThen FromArray.commonestWord _)(words)
  def commonestLetter(words: String) = (splitWords _ andThen FromArray.commonestLetter _)(words)

  object FromArray {
    def longest(words: Array[String]) = words.foldLeft("")((max, w) => if (max < w) w else max)
    def commonestWord(words: Array[String]) = commonestItem("")(words)
    def commonestLetter(words: Array[String]) = (wordsToChars _ andThen commonestItem(' '))(words)
  }

  def wordsToChars(words: Traversable[String]) = words flatMap (w => w.map(c => c))

  def commonestItem[E](zero: E)(items: Traversable[E]) = {
    val hist = items.foldLeft(Map[E, Int]())((map, w) => {
        val n = Try(map(w)) getOrElse 0
        map + (w -> (n + 1))
      })
    val maxKv = hist.foldLeft(zero -> 0)((max , kv) => if (max._2 < kv._2) kv else max)
    maxKv._1
  }

  def splitWords(words: String) = words.split(" ")
}
