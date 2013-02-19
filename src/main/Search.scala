package main

class Search(startPoint: State) {
	def Traverse : Stream[List[State]] = {
		def iter(states: List[State]) : Stream[List[State]] = {
		  val nextGen = states.map(_.neighbours).flatten
		  nextGen match {
		    case Nil => Stream.Empty
		    case _ => nextGen #:: iter(nextGen)
		  }
		}
		iter(List(startPoint)) 
	}
}