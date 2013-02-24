package main
import main._

class NumbersGameState ( val expressions: List[Expression], target: Int) extends State {
  
	def AllOperations(lhs:Expression,rhs:Expression):List[Expression] = {
	  
	  	val min = List(lhs,rhs).sortBy(_.value).head	
	  	val max = if (lhs == min) rhs else lhs

		def simpleOperations = List(
		    new Addition(min,max),
			new Subtraction(max,min))
			.filter(_.value > 0)
			
		def divisionOperation = {
		  if ( min.value > 1 && max.value % min.value == 0) 
		  	List(new Division(max,min)) 
		  else 
		  	List()
		}

		def multiplicationOperation = {
			if ( min.value > 1 && max.value > 1) 
				List(new Multiplication(min,max)) 
			else 
				List()
		}
		
		simpleOperations ::: divisionOperation ::: multiplicationOperation
	}
	
	def neighbours : List[NumbersGameState] = {
		if (expressions isEmpty) return Nil

		  
		for {
			pair <- expressions.combinations(2).toList
			newExpr <- AllOperations(pair(0),pair(1))
		}
		yield new NumbersGameState( newExpr :: expressions.filter( x => x.ne(pair(0)) && x.ne(pair(1))), target)
	}

	def isTarget = expressions.exists(_.value == target)
	
	override def toString = "{" + expressions.mkString(",") + "}"
}
