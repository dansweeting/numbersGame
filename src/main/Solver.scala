package main
import main.Countdown._

class Solver {
  def Solve( state: CountdownState, target: Int) : CountdownState = {
    
    def isSolved(cs: CountdownState) = {
      cs.expressions.exists(_.value == target)
    }
    
    lazy val solutions = new Search(state).Traverse.map(_.asInstanceOf[CountdownState]).filter(isSolved)
    solutions(0)
  }
}