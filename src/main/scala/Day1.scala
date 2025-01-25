import scala.math.abs

object Day1 {
  def twoListDistance(list1: List[Int], list2: List[Int]): Int = {
    list1.sorted.zip(list2.sorted).map { case (x, y) =>
      abs(x - y)
    }.sum
  }

  def similarityScore(list1: List[Int], list2: List[Int]): Int = {
    val occurrences = list2.groupMapReduce(identity)(_ => 1)(_ + _)
    list1.map(i => i * occurrences.getOrElse(i, 0)).sum
  }
}
