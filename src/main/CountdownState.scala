package main
import main._

	abstract class State {
	  def neighbours : List[State]
	}

	class Search(startPoint: State) {
	  def Traverse : Stream[List[State]] = {
	    worker(List(startPoint))
	  }
	  
	  def worker(states: List[State]) : Stream[List[State]] = states match {
	    case Nil => Stream.Empty
	    case _ => {
	      val nextGen = states.map(_.neighbours).flatten
	      nextGen #:: worker(nextGen)
	    }
	  }
	}

object Countdown {
  
	type Move = Expression
	
	class CountdownState ( val expressions: List[Expression]) extends State {
		def AllOperations(x:Expression,y:Expression):List[Move] = {
				List(x.Plus(y),
					x.Minus(y),
					y.Minus(x),
					x.Times(y))
		}
		
		def neighbours = expressions match {	
		  case head :: Nil => Nil
		  case _ =>
				for {
						pair <- expressions.combinations(2).toList
						newExpr <- AllOperations(pair(0),pair(1))
					}
				yield new CountdownState( newExpr :: expressions.filter( x => x.ne(pair(0)) && x.ne(pair(1))))
		}
		
		override def toString = "{" + expressions.mkString(",") + "}"
	}
}