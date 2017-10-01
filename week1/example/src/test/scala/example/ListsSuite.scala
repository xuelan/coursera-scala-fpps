package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
 @RunWith(classOf[JUnitRunner])
  class ListsSuite extends FunSuite {
 
  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   *   tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  test("one plus one is two")(assert(1 + 1 == 2))


  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  test("one plus one is three?") {
    assert(1 + 1 == 2) // This assertion fails! Go ahead and fix it.
  }


  /**
   * One problem with the previous (failing) test is that ScalaTest will
   * only tell you that a test failed, but it will not tell you what was
   * the reason for the failure. The output looks like this:
   *
   * {{{
   *    [info] - one plus one is three? *** FAILED ***
   * }}}
   *
   * This situation can be improved by using a special equality operator
   * `===` instead of `==` (this is only possible in ScalaTest). So if you
   * run the next test, ScalaTest will show the following output:
   *
   * {{{
   *    [info] - details why one plus one is not three *** FAILED ***
   *    [info]   2 did not equal 3 (ListsSuite.scala:67)
   * }}}
   *
   * We recommend to always use the `===` equality operator when writing tests.
   */
  test("details why one plus one is not three") {
    assert(1 + 1 === 2) // Fix me, please!
  }

  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }


  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */
  import Lists._


  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */

  val listNegative = List(-1,-2,-1000000)
  val listZeroRepeated = List(0,0,0)
  val listZeroOne = List(0,1,-4)
  val listEmpty = List()
  val listRepeat = List(-1,1,2,-2,-1,-2,2,2)
  val listBig = List(1000000,20000000,40000000)
  val listSmall = List(-1000000,-20000000,-40000000)
  val listMix = List(-4,-444444444,0,2,4,4,444444444)


  test("sum of negative numbers list") {
    assert(sum(listNegative) === -1000003)
  }

  test("sum of a repeated zeros numbers list ") {
    assert(sum(listZeroRepeated) === 0)
  }

  test("sum of a zero list") {
    assert(sum(listZeroOne) === -3)
  }

  test("sum of empty list") {
    assert(sum(listEmpty) === 0)
  }

  test("sum of repeats elements list") {
    assert(sum(listRepeat) === 1)
  }

  test("sum of big numbers list") {
    assert(sum(listBig) === 61000000)
  }

  test("sum of small numbers list") {
    assert(sum(listSmall) === -61000000)
  }

  test("sum of mix numbers list") {
    assert(sum(listMix) === 6)
  }




  test("max of negative numbers list") {
    assert(max(listNegative) === -1000000)
  }

  test("max of a repeated zeros numbers list") {
    assert(max(listZeroRepeated) === 0)
  }

  test("max of a zero list") {
    assert(max(listZeroOne) === -4)
  }

  test ("max of empty list") {
    val thrown = intercept[Exception] {
      max(listEmpty)
    }
    assert(thrown.getMessage === "empty")
  }

  test("max of repeats elements list") {
    assert(max(listRepeat) === 2)
  }

  test("max of big numbers list") {
    assert(max(listBig) === 40000000)
  }

  test("max of small numbers list") {
    assert(max(listSmall) === -40000000)
  }

  test("max of mix numbers list") {
    assert(max(listMix) === 444444444)
  }






}
