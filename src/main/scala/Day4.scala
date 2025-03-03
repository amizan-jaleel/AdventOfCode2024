object Day4 {
  def findXmas(grid: Array[Array[Char]]): Int = {
    val word = "XMAS"
    val rows = grid.length
    if(rows == 0) return 0
    val cols = grid(0).length
    val directions = List(
      (1, 0),  (-1, 0),  // Horizontal (right, left)
      (0, 1),  (0, -1),  // Vertical (down, up)
      (1, 1),  (-1, 1),  // Diagonal (down-right, down-left)
      (1, -1), (-1, -1)  // Diagonal (up-right, up-left)
    )

    def isValid(x: Int, y: Int, dx: Int, dy: Int): Boolean = {
      val newX = x + (word.length - 1) * dx
      val newY = y + (word.length - 1) * dy
      newX >= 0 && newX < rows && newY >= 0 && newY < cols
    }

    def matches(x: Int, y: Int, dx: Int, dy: Int): Boolean = {
      word.indices.forall { i =>
        word(i) == grid(x + i * dx)(y + i * dy)
      }
    }

    val allMatches = for {
      x <- 0 until rows
      y <- 0 until cols
      (dx, dy) <- directions
      if isValid(x, y, dx, dy)
    } yield matches(x, y, dx, dy)

    allMatches count identity
  }
}
