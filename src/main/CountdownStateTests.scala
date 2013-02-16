package main

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
 
@RunWith(classOf[JUnitRunner])
class CountdownStateTests extends FunSuite {
	
	test("When a state has two terms, it's neighbours should have the correct items") {
	  
	  val expressions = List(new Num(1),new Num(3))
	  val state = new CountdownState(expressions)
	  val neighbours = state.neighbours
	  
	  assert( neighbours.length === 4)
	  assert( neighbours.exists( _.exists( _.value == 1 + 3)))
	  assert( neighbours.exists( _.exists( _.value == 1 - 3)))
	  assert( neighbours.exists( _.exists( _.value == 3 - 1)))
	  assert( neighbours.exists( _.exists( _.value == 1 * 3)))
	}
}

