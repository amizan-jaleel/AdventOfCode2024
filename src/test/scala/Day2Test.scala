import org.specs2.mutable.Specification

class Day2Test extends Specification {

  "Day2Test" should {
    "pass part 1" in {
      "the basic test case" >> {
        val l1 = List(7,6,4,2,1)
        val l2 = List(1,2,7,8,9)
        val l3 = List(9,7,6,2,1)
        val l4 = List(1,3,2,4,5)
        val l5 = List(8,6,4,4,1)
        val l6 = List(1,3,6,7,9)

        Day2.isPurelyMonotonicWithMaxDiff(l1) must beTrue
        Day2.isPurelyMonotonicWithMaxDiff(l2) must beFalse
        Day2.isPurelyMonotonicWithMaxDiff(l3) must beFalse
        Day2.isPurelyMonotonicWithMaxDiff(l4) must beFalse
        Day2.isPurelyMonotonicWithMaxDiff(l5) must beFalse
        Day2.isPurelyMonotonicWithMaxDiff(l6) must beTrue
      }

      "reading the test input" >> {
        scala.io.Source
          .fromResource("day2.txt")
          .getLines().toList
          .map(line => line.split(" ").map(_.toInt).toList)
          .map(Day2.isPurelyMonotonicWithMaxDiff)
          .count(_ == true) mustEqual 549
      }
    }

    "pass part 2" in {
      "the simple case" >> {
        val l1 = List(7,6,4,2,1)
        val l2 = List(1,2,7,8,9)
        val l3 = List(9,7,6,2,1)
        val l4 = List(1,3,2,4,5)
        val l5 = List(8,6,4,4,1)
        val l6 = List(1,3,6,7,9)

        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l1) must beTrue
        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l2) must beFalse
        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l3) must beFalse
        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l4) must beTrue
        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l5) must beTrue
        Day2.isPurelyMonotonicWithMaxDiffAllowRemoval(l6) must beTrue
      }

      "reading the test input" >> {
        scala.io.Source
          .fromResource("day2.txt")
          .getLines().toList
          .map(line => line.split(" ").map(_.toInt).toList)
          .map(Day2.isPurelyMonotonicWithMaxDiffAllowRemoval)
          .count(_ == true) mustEqual 589
      }
    }
  }
}
