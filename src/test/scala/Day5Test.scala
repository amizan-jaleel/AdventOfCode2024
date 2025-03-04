import org.specs2.mutable.Specification

class Day5Test extends Specification {
  "Day4Test" should {
    "pass part 1" in {
      "the simple case" >> {
        val rules = scala.io.Source.fromResource("day5rules.txt").getLines().map { s =>
          val a = s.split("\\|").map(_.toInt)
          (a(0), a(1))
        }.toList
        val pages = scala.io.Source.fromResource("day5pages.txt").getLines().map { s =>
          s.split(",").map(_.toInt).toList
        }.toList
        Day5.printQueuePart1(rules, pages) mustEqual 143
      }

      "for the puzzle input" >> {
        val rules = scala.io.Source.fromResource("day5rulesPuzzleInput.txt").getLines().map { s =>
          val a = s.split("\\|").map(_.toInt)
          (a(0), a(1))
        }.toList
        val pages = scala.io.Source.fromResource("day5pagesPuzzleInput.txt").getLines().map { s =>
          s.split(",").map(_.toInt).toList
        }.toList
        Day5.printQueuePart1(rules, pages) mustEqual 6267
      }
    }
  }
}
