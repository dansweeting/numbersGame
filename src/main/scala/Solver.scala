package main
import main._

class Solver(ints: List[Int]) {
  
  def SolveFor(target: Int) = {
    
    def initialState = new NumbersGameState(ints.map(new Num(_)), target)
    
    def allStatesContainingTarget = new Search(initialState).Invoke.map(_.asInstanceOf[NumbersGameState])
    
    def listsFlattenedToExpressions = allStatesContainingTarget.flatten(_.expressions)
    
    listsFlattenedToExpressions.filter(_.value == target)  
  }
}
