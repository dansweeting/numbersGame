package test

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
 
@RunWith(classOf[JUnitRunner])
class NumbersGameStateTests extends FunSuite {
	test("Should detect adds,subtracts and multiplications") {
	  
	  val expressions = List(new Num(2),new Num(3))
	  val state = new NumbersGameState(expressions)
	  val neighbours = state.neighbours.map(_.asInstanceOf[NumbersGameState])

	  assert( neighbours.length === 3)
	  assert( neighbours.forall(_.expressions.length == 1))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(3 - 2)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(2 * 3)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(2 + 3)")))
	}
	
	test("Should detect adds, multiplication and division") {
	  
	  val expressions = List(new Num(5),new Num(25))
	  val state = new NumbersGameState(expressions)
	  val neighbours = state.neighbours.map(_.asInstanceOf[NumbersGameState])
	  
	  assert( neighbours.length === 4)
	  assert( neighbours.forall(_.expressions.length == 1))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(5 + 25)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(5 * 25)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(25 / 5)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(25 - 5)")))
	}
}

