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
  def countChange(money: Int, coins: List[Int]): Int = ???
}
