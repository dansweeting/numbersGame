package main

import main.Countdown._

object temp {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  val initialState = new CountdownState(List(new Num(1),new Num(2),new Num(3)))
                                                  //> initialState  : main.Countdown.CountdownState = {1,2,3}
  def isMatchingState( target: Int, state: State) = {
  	state.asInstanceOf[CountdownState].expressions.exists(_.value == target)
  }                                               //> isMatchingState: (target: Int, state: main.State)Boolean
  
  def isMatchingStates( target: Int, states: List[State]) = {
  	states.exists( isMatchingState(target,_))
  }                                               //> isMatchingStates: (target: Int, states: List[main.State])Boolean
  
  val search = new Search(initialState)           //> search  : main.Search = main.Search@1a84da23
  
  search.Traverse(1)                              //> res0: List[main.State] = List({((1 + 2) + 3)}, {((1 + 2) - 3)}, {(3 - (1 + 2
                                                  //| ))}, {((1 + 2) * 3)}, {((1 - 2) + 3)}, {((1 - 2) - 3)}, {(3 - (1 - 2))}, {((
                                                  //| 1 - 2) * 3)}, {((2 - 1) + 3)}, {((2 - 1) - 3)}, {(3 - (2 - 1))}, {((2 - 1) *
                                                  //|  3)}, {((1 * 2) + 3)}, {((1 * 2) - 3)}, {(3 - (1 * 2))}, {((1 * 2) * 3)}, {(
                                                  //| (1 + 3) + 2)}, {((1 + 3) - 2)}, {(2 - (1 + 3))}, {((1 + 3) * 2)}, {((1 - 3) 
                                                  //| + 2)}, {((1 - 3) - 2)}, {(2 - (1 - 3))}, {((1 - 3) * 2)}, {((3 - 1) + 2)}, {
                                                  //| ((3 - 1) - 2)}, {(2 - (3 - 1))}, {((3 - 1) * 2)}, {((1 * 3) + 2)}, {((1 * 3)
                                                  //|  - 2)}, {(2 - (1 * 3))}, {((1 * 3) * 2)}, {((2 + 3) + 1)}, {((2 + 3) - 1)}, 
                                                  //| {(1 - (2 + 3))}, {((2 + 3) * 1)}, {((2 - 3) + 1)}, {((2 - 3) - 1)}, {(1 - (2
                                                  //|  - 3))}, {((2 - 3) * 1)}, {((3 - 2) + 1)}, {((3 - 2) - 1)}, {(1 - (3 - 2))},
                                                  //|  {((3 - 2) * 1)}, {((2 * 3) + 1)}, {((2 * 3) - 1)}, {(1 - (2 * 3))}, {((2 * 
                                                  //| 3) * 1)})
  
  val target = 4                                  //> target  : Int = 4
  
 	val filtered = search.Traverse.filter( list => isMatchingStates(target,list))
                                                  //> filtered  : scala.collection.immutable.Stream[List[main.State]] = Stream(Lis
                                                  //| t({(1 + 2),3}, {(1 - 2),3}, {(2 - 1),3}, {(1 * 2),3}, {(1 + 3),2}, {(1 - 3),
                                                  //| 2}, {(3 - 1),2}, {(1 * 3),2}, {(2 + 3),1}, {(2 - 3),1}, {(3 - 2),1}, {(2 * 3
                                                  //| ),1}), ?)
  
  
  filtered(0).filter(x => isMatchingState(target,x))
                                                  //> res1: List[main.State] = List({(1 + 3),2})
    
}