import org.specs2.mutable.Specification

class Day1Test extends Specification {
  "Day1" should {
   "return 3" in {
     Day1.twoListDistance(List(1, 2, 3), List(2, 3, 4)) mustEqual 3
   }

   "read the test case" in {
     val source = scala.io.Source.fromResource("day1.txt")
     try {
       val (list1, list2) = source.getLines().foldLeft(List.empty[Int], List.empty[Int]) {
         case ((l1, l2), line) =>
           val nums = line.split("   ").toList.map(_.toInt)
           val (num1, num2) = (nums(0), nums(1))
           (num1 :: l1, num2 :: l2)
       }

       Day1.twoListDistance(list1.reverse, list2.reverse) mustEqual 2057374
     }
     finally {
       source.close()
     }
   }
  }
}
