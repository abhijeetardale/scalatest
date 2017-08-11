package scala.FeatureSpec

import org.scala.Stack
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

trait FeatureSpecStackBehaviors { this: FeatureSpec with GivenWhenThen =>

  def nonEmptyStack(createNonEmptyStack: => Stack[Int], lastItemAdded: Int) {

    scenario("empty is invoked on this non-empty stack: " + createNonEmptyStack.toString) {

      Given("a non-empty stack")
      val stack = createNonEmptyStack

      When("empty is invoked on the stack")
      Then("empty returns false")
      assert(!stack.empty)
    }

    scenario("peek is invoked on this non-empty stack: " + createNonEmptyStack.toString) {

      Given("a non-empty stack")
      val stack = createNonEmptyStack
      val size = stack.size

      When("peek is invoked on the stack")
      Then("peek returns the last item added")
      assert(stack.peek === lastItemAdded)

      And("the size of the stack is the same as before")
      assert(stack.size === size)
    }

    scenario("pop is invoked on this non-empty stack: " + createNonEmptyStack.toString) {

      Given("a non-empty stack")
      val stack = createNonEmptyStack
      val size = stack.size

      When("pop is invoked on the stack")
      Then("pop returns the last item added")
      assert(stack.pop === lastItemAdded)

      And("the size of the stack one less than before")
      assert(stack.size === size - 1)
    }

    scenario("size is invoked on this non-empty stack:" + createNonEmptyStack.toString) {

      Given("a non-empty stack")
      val stack = createNonEmptyStack

      When("size is invoked on the stack")
      Then("size returns correct value")
      assert(stack.size ==createNonEmptyStack.size)
    }
  }

  def nonFullStack(createNonFullStack: => Stack[Int]) {

    scenario("full is invoked on this non-full stack: " + createNonFullStack.toString) {

      Given("a non-full stack")
      val stack = createNonFullStack

      When("full is invoked on the stack")
      Then("full returns false")
      assert(!stack.full)
    }

    scenario("push is invoked on this non-full stack: " + createNonFullStack.toString) {

      Given("a non-full stack")
      val stack = createNonFullStack
      val size = stack.size

      When("push is invoked on the stack")
      stack.push(7)

      Then("the size of the stack is one greater than before")
      assert(stack.size === size + 1)

      And("the top of the stack contains the pushed value")
      assert(stack.peek === 7)
    }
  }
}