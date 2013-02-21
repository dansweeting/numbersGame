package main
import main._

class Solver(ints: List[Int]) {
  
  def SolveFor(target: Int) = {
    
    def initialState = new NumbersGameState(ints.map(new Num(_)))
    def isTarget(state: State) = state.asInstanceOf[NumbersGameState].expressions.exists(_.value == target)
    
    def searchTraversal = new Search(initialState,isTarget).Invoke
    
    searchTraversal.map(_.asInstanceOf[NumbersGameState]).flatten(_.expressions).filter(_.value == target)
  }
}
