package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0) 1
    else if (c == 0 || c == r) 1
    else if (c == 1 || (c + 1) == r) r;
    else pascal(r - 1, c - 1) + pascal(r - 1, c)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def isBalanced(chars: List[Char], acc: Int): Boolean = {
      if (chars.isEmpty && acc == 0) true    //Is Balanced
      else isBalanced(chars.tail, acc + verify(chars.head))
    }

    def verify(c: Char): Int = {
      if (c == '(') 1
      else if (c == ')') -1
      else 0
    }

    isBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
