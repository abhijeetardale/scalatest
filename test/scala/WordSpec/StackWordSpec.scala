package scala.WordSpec

import org.scala.Stack
import org.scalatest.WordSpec

/**
  * Created by user on 07/08/17.
  */
class StackWordSpec extends WordSpec with WordSpecStackBehaviors with StackTestHelper {

  "A Stack" when {

    "empty" should {

      "be empty" in {
        assert(emptyStack.empty)
      }

      "complain on peek" in {
        intercept[IllegalStateException] {
          emptyStack.peek
        }
      }

      "complain on pop" in {
        intercept[IllegalStateException] {
          emptyStack.pop
        }
      }

      behave like nonFullStack(emptyStack, 0)

    }

    "it contains one item" should {
      behave like nonEmptyStack(stackWithOneItem, lastValuePushed)
      behave like nonFullStack(stackWithOneItem, 1)
    }

    "it contains one item less than capacity" should {
      behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed)
      behave like nonFullStack(stackWithOneItemLessThanCapacity, 9)
    }

    "full" should {

      "be full" in {
        assert(fullStack.full)
      }

      behave like nonEmptyStack(fullStack, lastValuePushed)

      "complain on a push" in {
        intercept[IllegalStateException] {
          fullStack.push(10)
        }
      }

      "return size as 10" in {
        assert(fullStack.size == 10)
      }
    }
  }

}
