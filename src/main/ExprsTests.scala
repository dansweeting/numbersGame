package main

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
 
@RunWith(classOf[JUnitRunner])
class ExprTests extends FunSuite {
	
	test("When I add two Number expressions, value should sum the two numbers.") {
	  val x = new Num(2)
	  val y = new Num(2)
	  
	  assert(4 === x.Plus(y).value)
	}
	
	test("When I add two Number expressions, toString should describe the expression.") {
	  val x = new Num(2)
	  val y = new Num(3)
	  
	  assert("2 + 3" === x.Plus(y).toString())
	}
	
	test("When I add a combination of expressions, toString should describe the whole expression") {
	  val x = new Num(2)
	  val y = new Num(4)
	  
	  assert("2 + 4 + 1" === x.Plus(y).Plus(new Num(1)).toString())
	}
	
	test("When I subtract two number expressions x and y, the value should equate to x - y"){
	  
	  assert( 1 === new Num(100).Minus(new Num(99)).value)
	}
	
	test("When I multiply two number expressions x and y, the value should equate to x * y"){
	  
	  assert( 16 === new Num(4).Times(new Num(4)).value)
	}
}

