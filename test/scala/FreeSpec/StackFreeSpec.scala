package scala.FreeSpec

import org.scala.Stack
import org.scalatest.FreeSpec
/**
  * Created by user on 07/08/17.
  */
class StackFreeSpec extends FreeSpec with FreeSpecStackBehaviors with StackTestHelper {

  "A Stack" - {
    "when empty" - {
      "should be empty" in {
        assert(emptyStack.empty)
      }

      "should complain on peek" in {
        intercept[IllegalStateException] {
          emptyStack.peek
        }
      }

      "should complain on pop" in {
        intercept[IllegalStateException] {
          emptyStack.pop
        }
      }
    }

    "when it contains one item" - {
      "should" - {
        behave like nonEmptyStack(stackWithOneItem, lastValuePushed)
        behave like nonFullStack(stackWithOneItem)
      }
    }

    "when it contains one item less than capacity" - {
      "should" - {
        behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed)
        behave like nonFullStack(stackWithOneItemLessThanCapacity)
      }
    }

    "when full" - {
      "should be full" in {
        assert(fullStack.full)
      }

      "should" - {
        behave like nonEmptyStack(fullStack, lastValuePushed)
      }

      "should complain on a push" in {
        intercept[IllegalStateException] {
          fullStack.push(10)
        }
      }
    }
  }
}
