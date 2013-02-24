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
	  val state = new NumbersGameState(expressions,1)
	  val neighbours = state.neighbours.map(_.asInstanceOf[NumbersGameState]).toList

	  assert( neighbours.length === 3)
	  assert( neighbours.forall(_.expressions.length == 1))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(3 - 2)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(2 * 3)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(2 + 3)")))
	}
	
	test("Should detect adds, multiplication and division") {
	  
	  val expressions = List(new Num(5),new Num(25))
	  val state = new NumbersGameState(expressions,1)
	  val neighbours = state.neighbours.map(_.asInstanceOf[NumbersGameState]).toList
	  
	  assert( neighbours.length === 4)
	  assert( neighbours.forall(_.expressions.length == 1))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(5 + 25)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(5 * 25)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(25 / 5)")))
	  assert( neighbours.exists(_.expressions.exists(_.toString() == "(25 - 5)")))
	}

	test("Should detect when it contains the target expression.") {
	  
	  val expressions = List(new Addition(new Num(3),new Num(5)),new Num(25))
	  val state = new NumbersGameState(expressions, 8)
	  
	  assert( state.isTarget === true)
	}

	test("Should detect when it doesn't contain the target expression.") {
	  
	  val expressions = List(new Addition(new Num(2),new Num(2)))
	  val state = new NumbersGameState(expressions, 5)
	  
	  assert( state.isTarget === false)
	}
}

