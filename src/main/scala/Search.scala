package main
import scala.annotation.tailrec
class Search(startPoint: State) {
	
	def Invoke : Iterable[State] = { 
	  
	  @tailrec 
	  def iter(states: Iterable[State]) : Iterable[State] = {
	  	
	  	if (states isEmpty) return List()
	    
		if (states.exists(_.isTarget)) 
			states
		else 
			iter(states.flatten(_.neighbours)) 
	  }
	  
	  iter(List(startPoint))
	}
	
}