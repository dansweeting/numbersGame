package main
import main._

class CountdownState ( state: List[Expression]){ 
	def AllOperations(x:Expression,y:Expression):List[Expression] = {
			List(x.Plus(y),
				x.Minus(y),
				y.Minus(x),
				x.Times(y))
	}
	
	def neighbours = state match {
			
	  case head :: Nil => List(List(head))
	  case _ =>
			for {
					pair <- state.combinations(2).toList
					newExpr <- AllOperations(pair(0),pair(1))
				}
			yield newExpr :: state.filter( x => x.ne(pair(0)) && x.ne(pair(1)))
	}                                       
}