package scala.WordSpec

import org.scala.Stack
import org.scalatest.WordSpec

/**
  * Created by user on 07/08/17.
  */
trait WordSpecStackBehaviors { this: WordSpec =>

  def nonEmptyStack(newStack: => Stack[Int], lastItemAdded: Int) {

    "be non-empty" in {
      assert(!newStack.empty)
    }

    "return the top item on peek but do not remove the top item on peek" in {
      val stack = newStack
      val size = stack.size
      assert(stack.peek === lastItemAdded)
      assert(stack.size === size)
    }

    "remove the top item on pop" in {
      val stack = newStack
      val size = stack.size
      assert(stack.pop === lastItemAdded)
      assert(stack.size === size - 1)
    }

  }

  def nonFullStack(newStack: => Stack[Int], size:Int) {

    s"return size as ${size}" in {
      assert(newStack.size == size)
    }

    "not be full" in {
      assert(!newStack.full)
    }

    "add to the top on push" in {
      val stack = newStack
      val size = stack.size
      stack.push(7)
      assert(stack.size === size + 1)
      assert(stack.peek === 7)
    }
  }

}
