package main
import main._

class NumbersGameState ( val expressions: List[Expression]) extends State {
  
	def AllOperations(x:Expression,y:Expression):List[Expression] = {
	  
		def simpleOperations = List(
		    x.Plus(y),
			x.Minus(y),
			y.Minus(x),
			x.Times(y))
			
		def divisionOperation = {
		  val num = if (x.value > y.value) x else y
		  val denom = if (x.value <= y.value) x else y
		  
		  if (denom.value == 0) List()
		  if (num.value % denom.value == 0) List(x.DivideBy(y)) else List()
		}
		
		(simpleOperations ::: divisionOperation).filter(_.value > 0)
	}
	
	def neighbours = expressions match {	
		  case head :: Nil => Nil
		  case _ =>
				for {
						pair <- expressions.combinations(2).toList
						newExpr <- AllOperations(pair(0),pair(1))
					}
				yield new NumbersGameState( newExpr :: expressions.filter( x => x.ne(pair(0)) && x.ne(pair(1))))
		}
	
	override def toString = "{" + expressions.mkString(",") + "}"
}