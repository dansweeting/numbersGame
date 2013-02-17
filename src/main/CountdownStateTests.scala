package main

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import main.Countdown._
 
@RunWith(classOf[JUnitRunner])
class CountdownStateTests extends FunSuite {
	test("When a state has two terms, neighbours of that state should have the correct items") {
	  
	  val expressions = List(new Num(1),new Num(3))
	  val state = new CountdownState(expressions)
	  val neighbours = state.neighbours.map(_.asInstanceOf[CountdownState])
	  
	  assert( neighbours.length === 4)
	  assert( neighbours.forall(_.expressions.length == 1))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(1 + 3)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(1 - 3)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(3 - 1)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(1 * 3)")))
	}
}

