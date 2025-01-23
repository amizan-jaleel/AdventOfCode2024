import scala.math.abs

object Day1 {
  def twoListDistance(list1: List[Int], list2: List[Int]): Int = {
    list1.sorted.zip(list2.sorted).map { case (x, y) =>
      abs(x - y)
    }.sum
  }
}
