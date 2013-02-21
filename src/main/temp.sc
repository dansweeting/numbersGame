package main

import main._

object temp {
                                       
  def exprs = new Solver(List(25,50,75,100,3,6)).SolveFor(900)
                                                  //> exprs: => List[main.Expression]
  
  //def exprs = new Solver(List(1,1,1)).SolveFor(4)
  
  
  exprs.map( x => x.toString() + " = " + x.value ).mkString("\n")
                                                  //> res0: String = ((50 + 100) * 6) = 900
                                                  //| ((50 * 3) * 6) = 900
                                                  //| ((50 * 6) * 3) = 900
                                                  //| ((3 + 6) * 100) = 900
                                                  //| ((3 * 6) * 50) = 900
}