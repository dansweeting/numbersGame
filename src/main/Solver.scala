package main
import main._

class Solver(ints: List[Int]) {
  
  def SolveFor(target: Int) = {
    def initialState = new NumbersGameState(ints.map(new Num(_)))
    def searchTraversal = new Search(initialState).Traverse
    
    def stateContainsSolution(state: State) = {
      state.asInstanceOf[NumbersGameState].expressions.exists( _.value == target )
    }
    
    def statesContainsSolution(state: List[State]) = {
      state.exists(stateContainsSolution)
    }
    
    val traversalWithSolution = new Search(initialState).Traverse.filter(statesContainsSolution)
    if (traversalWithSolution.isEmpty) {
      List()
    }
    else {
      def states = traversalWithSolution(0).filter(stateContainsSolution).map(_.asInstanceOf[NumbersGameState])
      states.flatten(_.expressions).filter(_.value == target)
    }
  }
}
