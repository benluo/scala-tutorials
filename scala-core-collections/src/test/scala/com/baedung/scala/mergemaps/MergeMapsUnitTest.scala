package com.baedung.scala.mergemaps

import com.baeldung.scala.mergemaps.CombineIterables
import org.scalatest.{FlatSpec, Matchers}

class MergeMapsUnitTest extends FlatSpec with Matchers {

  "++ operator" should "merge maps preferring duplicates from second map" in {
    val firstMap = Map(1 -> "Apple", 5 -> "Banana", 3 -> "Orange");
    val secondMap = Map(5 -> "Pear", 4 -> "Cherry");

    firstMap ++ secondMap should equal(
      Map(1 -> "Apple", 5 -> "Pear", 3 -> "Orange", 4 -> "Cherry")
    )
  }

  "combineIterables" should "combine values for duplicate keys" in {
    val firstMap = Map(1 -> List(1, 2, 3))
    val secondMap = Map(1 -> List(4, 5))

    CombineIterables.combineIterables(firstMap, secondMap) should equal(
      Map(1 -> List(4, 5, 1, 2, 3))
    )
  }
}
