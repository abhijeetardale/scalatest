package scala.WordSpec

import org.scala.Stack
import org.scalatest.WordSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StackExampleJavaTest extends WordSpec with JavaStackTestHelper {

  "A Stack" when  {

    "calling size" should {

      "return 0 if empty" in {
        assert(emptyStack.size == 0)
      }
      "return 1 if stack with one tem" in {
        assert(stackWithOneItem.size == 1)
      }
      "return 9 if stack is with one item less than its capacity" in {
        assert(stackWithOneItemLessThanCapacity.size == 9)
      }
      "return 10 if stack is full" in {
        assert(fullStack.size == 10)
      }
    }

    "calling empty" should {

      "return true if empty" in {
        assert(emptyStack.empty)
      }
      "return false if contains 1 elemen" in {
        assert(stackWithOneItem.empty==false)
      }
      "return false if stack is with one item less than its capacity" in {
        assert(stackWithOneItemLessThanCapacity.empty==false)
      }
      "return false if stack is full" in {
        assert(fullStack.empty==false)
      }
    }

    "calling peek" should {

      "complain on peek if empty" in {
        intercept[IllegalStateException] {
          emptyStack.peek
        }
      }
      "return the top item on peek but do not remove the top item on peek if contains 1 element" in {
        val stack = stackWithOneItem
        val size = stackWithOneItem.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
      "return the top item on peek but do not remove the top item on peek if stack is with one item less than its capacity" in {
        val stack = stackWithOneItemLessThanCapacity
        val size = stackWithOneItemLessThanCapacity.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
      "return the top item on peek but do not remove the top item on peek if stack is full" in {
        val stack = fullStack
        val size = fullStack.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
    }

    "calling pop" should {

      "complain on pop if empty" in {
        intercept[IllegalStateException] {
          emptyStack.pop
        }
      }
      "remove the top item on pop and stack will be empty if contains 1 element" in {
        val stack = stackWithOneItem
        val size = stackWithOneItem.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty)
      }
      "remove the top item on pop and stack size will be reduded by 1 if stack is with one item less than its capacity" in {
        val stack = stackWithOneItemLessThanCapacity
        val size = stackWithOneItemLessThanCapacity.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty==false)
      }
      "remove the top item on pop and stack size will be reduded by 1 if stack is full" in {
        val stack = fullStack
        val size = fullStack.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty==false)
      }
    }

    "calling push" should {

      "add to the top on push if empty" in {
        val stack = emptyStack
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
      }

      "add to the top on push and stack will not be empty if contains 1 element" in {
        val stack = stackWithOneItem
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
      }
      "add to the top on push and stack size will be full if stack is with one item less than its capacity" in {
        val stack = stackWithOneItemLessThanCapacity
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
        assert(stack.full)
      }

      "complain on a push if stack is full" in {
        intercept[IllegalStateException] {
          fullStack.push(10)
        }
      }
    }

    "calling full" should {

      "return false if stack is empty" in {
        val stack = emptyStack
        assert(stack.full==false)
      }

      "add to the top on push and stack will not be empty if contains 1 element" in {
        val stack = stackWithOneItem
        assert(stack.full==false)
      }
      "add to the top on push and stack size will be full if stack is with one item less than its capacity" in {
        val stack = stackWithOneItemLessThanCapacity
        assert(stack.full==false)
      }

      "return true if stack is full" in {
        val stack = fullStack
        assert(stack.full)
      }
    }

  }

}
