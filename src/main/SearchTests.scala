package main
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import main.Countdown._

class StubState (val name:String,  _neighbours: List[State] = Nil) extends State {
  def neighbours = _neighbours
}
 
@RunWith(classOf[JUnitRunner])
class SearchTests extends FunSuite {
	test("When a state has no neighbouring moves, Traverse should return an empty stream.") {
	  
	  val state = new StubState("No neighbours")  
	  val search = new Search(state).Traverse.toList
	
	  assert( search.length === 0)
	}
	
	test("When a state has one neighbouring move, Traverse should return the state in a stream") {
	  
	  val state = new StubState("I have one neighbour", List(new StubState("Here's the neighbour")))  
	  val search = new Search(state).Traverse.flatten( x => x).map( _.asInstanceOf[StubState])
	
	  assert( search.length === 1)
	  assert( search(0).name === "Here's the neighbour")
	}
	
}

