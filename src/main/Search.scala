package main
import scala.annotation.tailrec
class Search(startPoint: State, isTarget: State => Boolean = null) {
	
	def Invoke : List[State] = { 
	  
	  @tailrec 
	  def iter(states: List[State]) : List[State] = states match {
	    case Nil => Nil
	    case _ => {
	      if (states.exists(isTarget)) states else iter(states.flatten(_.neighbours)) 
	    }  
	  }
	  iter(List(startPoint))
	}
	
}