import org.specs2.mutable.Specification

class Day1Test extends Specification {
  "Day1" should {
   "pass a simple test case for part 1" in {
     Day1.twoListDistance(List(1, 2, 3), List(2, 3, 4)) mustEqual 3
   }

   "pass a simple test case for part 2" in {
     val l1 = List(3,4,2,1,3,3)
     val l2 = List(4,3,5,3,9,3)

     Day1.similarityScore(l1, l2) mustEqual 31
   }

   "read the test case" in {
     val source = scala.io.Source.fromResource("day1.txt")
     try {
       val (list1R, list2R) = source.getLines().foldLeft(List.empty[Int], List.empty[Int]) {
         case ((l1, l2), line) =>
           val nums = line.split(" {3}").toList.map(_.toInt)
           val (num1, num2) = (nums.head, nums(1))
           (num1 :: l1, num2 :: l2)
       }
       val (list1, list2) = (list1R.reverse, list2R.reverse)

       Day1.twoListDistance(list1, list2) mustEqual 2057374
       Day1.similarityScore(list1, list2) mustEqual 23177084
     }
     finally {
       source.close()
     }
   }
  }
}
