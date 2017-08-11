package scala

import org.scala.Stack

trait StackTestHelper {


  val lastValuePushed = 9

  def emptyStack : Stack[Int] = new Stack[Int]

  def fullStack : Stack[Int] = {
    val stack = new Stack[Int]
    for (i <- 0 until stack.MAX)
      stack.push(i)
    stack
  }

  def stackWithOneItem : Stack[Int] =  {
    val stack = new Stack[Int]
    stack.push(9)
    stack
  }

  def stackWithOneItemLessThanCapacity : Stack[Int] =  {
    val stack = new Stack[Int]
    for (i <- 1 to 9)
      stack.push(i)
    stack
  }

}
