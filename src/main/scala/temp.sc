package main

import main._

object temp {
                                       
  def exprs = new Solver(List(25,50,75,100,3,6)).SolveFor(952)
                                                  //> exprs: => <error>
                                                  
  //def exprs = new Solver(List(1,3,7,10,25,50)).SolveFor(831)
  
  
  def stopwatch[T]( invocation: =>T) : (T,Long) = {
  	val startTime = System.currentTimeMillis()
  	val result = invocation
  	val endTime = System.currentTimeMillis()
  	
  	(invocation,(endTime-startTime))
  }                                               //> stopwatch: [T](invocation: => T)(T, Long)
  
  def runSearch = exprs.map( x => x.toString() + " = " + x.value ).mkString("\n")
                                                  //> runSearch: => <error>-
                                                  
	stopwatch(runSearch)
	
	
	
}