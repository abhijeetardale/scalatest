package scala.FlatSpec

import org.scala.Stack
import org.scalatest.FlatSpec

/**
  * Created by user on 07/08/17.
  */
class StackFlatSpec extends FlatSpec with FlatSpecStackBehaviors with StackTestHelper {

  "A Stack (when empty)" should "be empty" in {
    assert(emptyStack.empty)
  }

  it should "complain on peek" in {
    intercept[IllegalStateException] {
      emptyStack.peek
    }
  }

  it should "complain on pop" in {
    intercept[IllegalStateException] {
      emptyStack.pop
    }
  }

  "A Stack (with one item)" should behave like nonEmptyStack(stackWithOneItem, lastValuePushed)

  it should behave like nonFullStack(stackWithOneItem)

  "A Stack (with one item less than capacity)" should behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed)

  it should behave like nonFullStack(stackWithOneItemLessThanCapacity)

  "A Stack (full)" should "be full" in {
    assert(fullStack.full)
  }

  it should behave like nonEmptyStack(fullStack, lastValuePushed)

  it should "complain on a push" in {
    intercept[IllegalStateException] {
      fullStack.push(10)
    }
  }

}
