package scala.FeatureSpec

import org.scala.Stack
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

class StackFeatureSpec extends FeatureSpec with GivenWhenThen with FeatureSpecStackBehaviors with StackTestHelper {

  feature("A org.scala.Stack is pushed and popped") {

    scenario("empty is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("empty is invoked on the stack")
      Then("empty returns true")
      assert(stack.empty)
    }

    scenario("size is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("size is invoked on the stack")
      Then("size returns 0")
      assert(stack.size ==0)
    }

    scenario("peek is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("peek is invoked on the stack")
      Then("peek throws IllegalStateException")
      intercept[IllegalStateException] {
        stack.peek
      }
    }

    scenario("pop is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("pop is invoked on the stack")
      Then("pop throws IllegalStateException")
      intercept[IllegalStateException] {
        emptyStack.pop
      }
    }

    scenariosFor(nonEmptyStack(stackWithOneItem, lastValuePushed))
    scenariosFor(nonFullStack(stackWithOneItem))

    scenariosFor(nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed))
    scenariosFor(nonFullStack(stackWithOneItemLessThanCapacity))

    scenario("full is invoked on a full stack") {

      Given("an full stack")
      val stack = fullStack

      When("full is invoked on the stack")
      Then("full returns true")
      assert(stack.full)
    }

    scenariosFor(nonEmptyStack(fullStack, lastValuePushed))

    scenario("push is invoked on a full stack") {

      Given("an full stack")
      val stack = fullStack

      When("push is invoked on the stack")
      Then("push throws IllegalStateException")
      intercept[IllegalStateException] {
        stack.push(10)
      }
    }

    scenario("size is invoked on an full stack") {

      Given("an full stack")
      val stack = fullStack

      When("size is invoked on the stack")
      Then("size returns 10")
      assert(stack.size ==10)
    }

  }
}