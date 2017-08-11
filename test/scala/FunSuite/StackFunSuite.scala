package scala.FunSuite

import org.scala.Stack
import org.scalatest.FunSuite
/**
  * Created by user on 07/08/17.
  */
class StackFunSuite  extends FunSuite with FunSuiteStackBehaviors with StackTestHelper {

  test("empty is invoked on an empty stack") {
    val stack = emptyStack
    assert(stack.empty)
  }

  test("peek is invoked on an empty stack") {
    val stack = emptyStack
    intercept[IllegalStateException] {
      stack.peek
    }
  }

  test("pop is invoked on an empty stack") {
    val stack = emptyStack
    intercept[IllegalStateException] {
      emptyStack.pop
    }
  }

  testsFor(nonEmptyStack(stackWithOneItem, lastValuePushed))
  testsFor(nonFullStack(stackWithOneItem))

  testsFor(nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed))
  testsFor(nonFullStack(stackWithOneItemLessThanCapacity))

  test("full is invoked on a full stack") {
    val stack = fullStack
    assert(stack.full)
  }

  testsFor(nonEmptyStack(fullStack, lastValuePushed))

  test("push is invoked on a full stack") {
    val stack = fullStack
    intercept[IllegalStateException] {
      stack.push(10)
    }
  }
}