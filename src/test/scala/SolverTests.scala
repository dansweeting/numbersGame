package test

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SolverTests extends FunSuite {

	/*test("Should find solutions by adding and multiplying") {
	  
	  val solver = new Solver(List(2,2,7))
	  val solution = solver.SolveFor(4)
	  
	  assert(2 === solution.length)
	  assert(solution.exists(_.toString() == "(2 + 2)"))
	  assert(solution.exists(_.toString() == "(2 * 2)"))
	}
	
	test("Should find solutions with division") {
	  val solver = new Solver(List(100,25,7,19))
	  val solution = solver.SolveFor(4)
	  
	  assert(1 === solution.length)
	  assert(solution.exists(_.toString() == "(100 / 25)"))
	}
	
	test("Should return empty list when there's not a solution") {
	  val solver = new Solver(List(100,25))
	  val solution = solver.SolveFor(99)
	  
	  assert(0 === solution.length)
	}*/

	test("Should solve 952") {
	  val solver = new Solver(List(100,75,50,25,6,3))
	  val solution = solver.SolveFor(952)
	  
	  assert(solution.isEmpty === false)
	}
}