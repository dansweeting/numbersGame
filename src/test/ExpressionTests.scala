package test

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
 
@RunWith(classOf[JUnitRunner])
class ExpressionTests extends FunSuite {
	
	test("When I add two Number expressions, value should sum the two numbers.") {
	  val x = new Num(2)
	  val y = new Num(2)
	  
	  assert(4 === new Addition(x,y).value)
	}
	
	test("When I add two Number expressions, toString should describe the expression.") {
	  val x = new Num(2)
	  val y = new Num(3)
	  
	  assert("(2 + 3)" === new Addition(x,y).toString())
	}
	
	test("When I add a combination of expressions, toString should describe the whole expression") {
	  val x = new Num(2)
	  val y = new Num(4)
	  
	  assert("((2 + 4) + 1)" === new Addition(new Addition(x,y),new Num(1)).toString())
	}
	
	test("When I subtract two number expressions x and y, the value should equate to x - y"){
	  
	  assert( 1 === new Subtraction(new Num(100),new Num(99)).value)
	}
	
	test("When I multiply two number expressions x and y, the value should equate to x * y"){
	  
	  assert( 16 ===  new Multiplication(new Num(4),new Num(4)).value)
	}
}

