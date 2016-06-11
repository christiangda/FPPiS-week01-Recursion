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
  def pascal(col: Int, row: Int): Int = {

    def pascalAccumulator(i: Int, acc: Int): Int = {
      val a = if (col > row / 2) col else row - col
      if (i == a + 1) acc
      else pascalAccumulator(i + 1, acc * (row - a + i) / i)
    }

    pascalAccumulator(1, 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def isBalanced(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty && stack.isEmpty) true
      else if (chars.isEmpty && !stack.isEmpty) false
      else isBalanced(chars.tail, verify(chars.head, stack))
    }

    def remove(list: List[Char]): List[Char] = list diff List('(')
    def add(list: List[Char]): List[Char] = '(' :: list

    def verify(c: Char, s: List[Char]): List[Char] = {
      if (c == '(') add(s)
      else if (c == ')') {
        if (s.length == 0) "NoEmptyList".toList
        else remove(s)
      } else s
    }

    isBalanced(chars, "".toList)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.contains(0)) 0
    else if (money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0
  }
}
