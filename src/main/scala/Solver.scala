package main
import main._

class Solver(ints: List[Int]) {
  
  def SolveFor(target: Int) = {
    
    def initialState = new NumbersGameState(ints.map(new Num(_)))
    def isTarget(state: State) = state.asInstanceOf[NumbersGameState].expressions.exists(_.value == target)
    
    def allStatesContainingTarget = new Search(initialState,isTarget).Invoke.map(_.asInstanceOf[NumbersGameState])
    
    def listsFlattenedToExpressions = allStatesContainingTarget.flatten(_.expressions)
    
    listsFlattenedToExpressions.filter(_.value == target)  
  }
}
