numbersGame
===========

Virtual Carol Vorderman (Toying around with breadth-first search problems in scala)

example
=======

'Four from the top and two small ones.'

def exprs = new Solver(List(25,50,75,100,3,6)).SolveFor(280)
                                                  //> exprs: => List[main.Expression]
  
  exprs.map( x => x.toString() + " = " + x.value ).mkString("\n")
                                                  //> res0: String = ((((100 - 6) * 75) - 50) / 25) = 280

More text
