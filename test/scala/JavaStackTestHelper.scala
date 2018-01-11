package scala

import org.java.JavaStack

trait JavaStackTestHelper {


  val lastValuePushed = 9

  def emptyStack : JavaStack[Int] = new JavaStack[Int]

  def fullStack : JavaStack[Int] = {
    val stack = new JavaStack[Int]
    for (i <- 0 until stack.MAX)
      stack.push(i)
    stack
  }

  def stackWithOneItem : JavaStack[Int] =  {
    val stack = new JavaStack[Int]
    stack.push(9)
    stack
  }

  def stackWithOneItemLessThanCapacity : JavaStack[Int] =  {
    val stack = new JavaStack[Int]
    for (i <- 1 to 9)
      stack.push(i)
    stack
  }

}
