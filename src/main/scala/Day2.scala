object Day2 {
  def isPurelyMonotonicWithMaxDiff(list: List[Int]): Boolean = {
    if (list.length < 2) return true // A list with 0 or 1 element is trivially monotonic

    val diffs = list.sliding(2).map {
      case a :: b :: Nil => b - a
    }.toList

    val allIncreasing = diffs.forall(_ > 0)
    val allDecreasing = diffs.forall(_ < 0)
    val maxDiffValid = diffs.forall(diff => math.abs(diff) <= 3 && diff != 0)

    (allIncreasing || allDecreasing) && maxDiffValid
  }
}
