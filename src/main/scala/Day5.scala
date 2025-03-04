object Day5 {
  private def verifyRules(
    rules: List[(Int, Int)],
    pages: List[Int],
  ): Boolean = {
    val indexMapping = pages.zipWithIndex.toMap
    rules.forall { case (p1, p2) =>
      val i1 = indexMapping.get(p1)
      val i2 = indexMapping.get(p2)

      (i1, i2) match {
        case (Some(idx1), Some(idx2)) =>
          idx1 < idx2
        case _ =>
          true
      }
    }
  }

  private def filterDownPages(
    rules: List[(Int, Int)],
    allPages: List[List[Int]],
  ): List[List[Int]] = allPages.filter { pages =>
    verifyRules(rules, pages)
  }

  def printQueuePart1(
    rules: List[(Int, Int)],
    allPages: List[List[Int]],
  ): Int = {
    val remainingPages = filterDownPages(rules, allPages)
    remainingPages.map(l => l(l.size/2)).sum
  }
}
