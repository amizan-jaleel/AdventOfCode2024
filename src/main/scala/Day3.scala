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
}
