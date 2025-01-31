object Day3 {
  def sumValidMultiplications(input: String): Int = {
    // Define a regex pattern to match valid mul(X, Y) instances
    val pattern = """mul\((\d+),(\d+)\)""".r

    // Find all matches, extract X and Y, convert to integers, and perform multiplications
    val products = pattern.findAllMatchIn(input).map { m =>
      val x = m.group(1).toInt
      val y = m.group(2).toInt
      x * y
    }

    // Sum up all products
    products.sum
  }

  def sumValidMultiplicationsWithDosAndDonts(input: String): Int = {
    // Define patterns for `do()`, `don't()`, and `mul(X, Y)`
    val doPattern = """do\(\)""".r
    val dontPattern = """don't\(\)""".r
    val mulPattern = """mul\((\d+),(\d+)\)""".r

    // Split the input into tokens based on the "do()" and "don't()" markers
    val tokens = input.split("""(?=do\(\)|don't\(\))""").toList // Split but retain the markers

    def sumProducts(t: String) = mulPattern.findAllMatchIn(t).map { m =>
      val x = m.group(1).toInt
      val y = m.group(2).toInt
      x * y
    }.sum

    tokens match {
      case Nil => 0 // return 0 for empty case
      case head :: tail =>
        val initialSum = sumProducts(head)
        // Fold through the tokens to calculate the sum
        tail.foldLeft(initialSum) { case (sum, token) =>
          token.trim match {
            case t if doPattern.findFirstIn(t).isDefined =>
              // Enable multiplication and process any mul() in the same token
              sum + sumProducts(t)

            case t if dontPattern.findFirstIn(t).isDefined =>
              sum // Disable multiplication

            case _ => sum
          }
        }
    }
  }
}
