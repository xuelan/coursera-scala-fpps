import course._

object nth{

  println("test")

  def nth[T](n:Int, list: List[T]):T = {
    if(n==0){
      list.head
    } else if (n>0) {
      nth(n-1, list.tail)
    } else {
      throw new IndexOutOfBoundsException("OutOfBound")
    }
  }

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  nth(2, list)

}