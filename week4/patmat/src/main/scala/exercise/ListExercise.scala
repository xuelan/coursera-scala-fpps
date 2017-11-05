

object test extends App {

  def squareListWithPatternMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y*y :: squareListWithPatternMatch(ys)
  }

  def squareListWithMap(xs: List[Int]): List[Int] = xs map (x => x*x)

  val list = List(2,5,7,9)

  println(squareListWithPatternMatch(list))

  println("Map: ")
  println(squareListWithMap(list))

  val listFiltered = list filter (x => x > 2)

  println("Filter: ")
  println(listFiltered)

  val pairePartitioned = list partition (x => x > 4)

  println("Partition 1: ")
  println(pairePartitioned)
  println("Partition 2: ")
  println(pairePartitioned)

  val listTakeWhile = list takeWhile (x => x < 6)
  println("Take while: ")
  println(listTakeWhile)

  val listDropWhile = list dropWhile (x => x <6)
  println("Drop while: ")
  println(listDropWhile)

}