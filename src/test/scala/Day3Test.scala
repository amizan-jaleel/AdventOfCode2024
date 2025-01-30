import org.specs2.mutable.Specification

class Day3Test extends Specification {
  "Day 3" should {
    "pass part 1" in {
      "the simple case" >> {
        val s = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        Day3.sumValidMultiplications(s) mustEqual 161
      }

      "reading from a file" >> {
        val input = scala.io.Source.fromResource("day3.txt").getLines().toList.head
        Day3.sumValidMultiplications(input) mustEqual 33494469 // not correct
      }
    }
  }
}
