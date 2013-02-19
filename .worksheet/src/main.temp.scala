package main

import main._

object temp {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 
                                  
       
  def exprs = new Solver(List(25,50,75,100,3,6)).SolveFor(28);System.out.println("""exprs: => List[main.Expression]""");$skip(69); val res$0 = 
  
  exprs.map( x => x.toString() + " = " + x.value ).mkString("\n");System.out.println("""res0: String = """ + $show(res$0))}
}