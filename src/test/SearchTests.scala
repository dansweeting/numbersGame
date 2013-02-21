package test
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import main._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SearchTests extends FunSuite {
	class StubState (val name:String,  _neighbours: List[State] = List()) extends State {
		def neighbours = _neighbours
	}
  
	test("When a state satisfies the initial target condition, Invoke should return the state.") {
	  val state = new StubState("No neighbours")  
	  val search = new Search(state, (x) => true ).Invoke
	  
	  assert(search(0).asInstanceOf[StubState].name === state.name)
	}
	
	test("When a state's immediate neighbour satisfies the initial target condition, Invoke should return the state that satisfies the condition.") {
	  
	  val neighbour = new StubState("Neighbouring state")
	  val state = new StubState("InitialState",List(neighbour))
	  
	  def isTargetState(state:State) = state.asInstanceOf[StubState].name == neighbour.name
	  
	  val search = new Search(state, isTargetState ).Invoke
	  
	  assert(search(0).asInstanceOf[StubState].name === neighbour.name)
	}
	
	test("When a state and its neighbours do not satisfy the target condition, Invoke should return an empty list") {
	  val state = new StubState("No neighbours")  
	  val search = new Search(state, (x) => false ).Invoke
	  
	  assert(search.isEmpty === true)
	}
}

