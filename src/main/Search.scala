package main

class Search(startPoint: State, isTarget: State => Boolean = null) {
	
  
	def Invoke : State = { 
	  def iter(states: List[State]) : State = states match {
	    case Nil => null
	    case _ => {
	      val found = states.find(isTarget).orNull
	      if (found != null) {
	        found
	      }
	      else {
	        iter(states.flatten( x => x.neighbours))
	      }
	    }  
	  }
	  iter(List(startPoint))
	}
	
}