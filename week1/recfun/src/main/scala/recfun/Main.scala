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
  def pascal(c: Int, r: Int): Int = (c, r) match {
    case (0, _) => 1
    case (c, r) if (c == r) => 1
    case _ => pascal(c, r - 1) + pascal(c - 1, r - 1)

  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    val leftNum = 0
    balanceRecursive(chars, leftNum)
  }

  def balanceRecursive(chars: List[Char], leftNum: Int): Boolean = (chars, leftNum) match {
    case (Nil, _) => leftNum == 0
    case (chars, leftNum) if(leftNum<0)=> false
    case ('('::tail, leftNum) => balanceRecursive(tail , leftNum+1)
    case (')'::tail, leftNum) => balanceRecursive(tail , leftNum-1)
    case (_::tail, leftNum) => balanceRecursive(tail, leftNum)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (_, Nil) => 0
    case (0, _) => 1
    case (money, _) if(money<0) => 0
    case (money, head::tail) => countChange(money - head, coins) + countChange(money, tail)
  }


}