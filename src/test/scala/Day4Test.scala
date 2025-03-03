import org.specs2.mutable.Specification

class Day4Test extends Specification {

  "Day4Test" should {
    "pass part 1" in {
      "the simple case" >> {
        val input =
          """MMMSXXMASM
            |MSAMXMSMSA
            |AMXSXMAAMM
            |MSAMASMSMX
            |XMASAMXAMM
            |XXAMMXXAMA
            |SMSMSASXSS
            |SAXAMASAAA
            |MAMMMXMMMM
            |MXMXAXMASX
            |""".stripMargin

        val grid = input.lines.toArray().map(_.toString.toCharArray)

        Day4.findXmas(grid) mustEqual 18
      }

      "reading from a file" >> {
        val input = scala.io.Source.fromResource("day4.txt").getLines().toList.toArray.map(_.toCharArray)
        Day4.findXmas(input) mustEqual 2297
      }
    }
  }
}
