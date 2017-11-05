

object test extends App {

  def squareListWithPatternMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y*y :: squareListWithPatternMatch(ys)
  }

  def squareListWithMap(xs: List[Int]): List[Int] = xs map (x => x*x)

  val list = List(2,5,7)

  squareListWithPatternMatch(list).foreach(x => println("Pattern Match: " + x))

  squareListWithMap(list).foreach(x => println("Map: " + x))
}