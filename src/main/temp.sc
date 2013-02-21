package main

import main._

object temp {
                                  
       
  def exprs = new Solver(List(25,50,75,100,3,6)).SolveFor(28)
  
                                                  //> exprs: => List[main.Expression]
  
  exprs.map( x => x.toString() + " = " + x.value ).mkString("\n")
                                                  //> res0: String = (25 + 3) = 28
}