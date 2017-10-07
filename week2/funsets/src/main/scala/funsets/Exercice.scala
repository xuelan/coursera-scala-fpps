package funsets


object Exercice extends App {
  /*======================== Exercices 2.2 Currying ========================*/

  println("========> Sum")
  println(sum(x=>x*x)(3,5))

  println("========> Product")
  println(product(x => x*x)(3,7))

  println("========> Factorial")
  println(factorial(x => x*x)(3))

  println("========> Factorial2")
  println(factorial2(x => x*x)(3))


  println("========> Mapreduce")
  println(mapReduce(x => x*x, (x,y)=>x+y)(3,5,0))


  /*======================== Exercices 2.3 Functions and Data ========================*/




  /*======================== sum and product ========================*/


  def sum(f: Int=>Int) (a: Int, b: Int):Int = {
    if(a>b) 0 else f(a)+sum(f)(a+1, b)
  }

  def product(f: Int => Int) (a: Int, b: Int):Int =
    if(a>b) 1
    else f(a)*product(f)(a+1,b)

  /*======================== factorial based on product ========================*/

  def factorial(f: Int => Int)(n:Int):Int = {
    def product(f: Int => Int) (a: Int, b: Int):Int =
      if(a>b) 1
      else f(a)*product(f)(a+1,b)
    product(f)(1,n)
  }

  def factorial2(f:Int => Int)(n:Int):Int = product(f)(1,n)


  /*======================== Generalize sum and product, with f() [this is awesome!!!] ========================*/


  def mapReduce(f:Int => Int, combine: (Int, Int) => Int)(a:Int, b:Int, beginParam:Int):Int = {
    if(a>b){
      beginParam
    } else {
      combine(f(a), mapReduce(f, combine)(a+1,b,beginParam))
    }
  }
}
