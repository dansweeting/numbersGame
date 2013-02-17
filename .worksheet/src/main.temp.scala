package main

import main.Countdown._

object temp {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(86); 
  
  
  val initialState = new CountdownState(List(new Num(1),new Num(2),new Num(3)));System.out.println("""initialState  : main.Countdown.CountdownState = """ + $show(initialState ));$skip(134); 
  def isMatchingState( target: Int, state: State) = {
  	state.asInstanceOf[CountdownState].expressions.exists(_.value == target)
  };System.out.println("""isMatchingState: (target: Int, state: main.State)Boolean""");$skip(114); 
  
  def isMatchingStates( target: Int, states: List[State]) = {
  	states.exists( isMatchingState(target,_))
  };System.out.println("""isMatchingStates: (target: Int, states: List[main.State])Boolean""");$skip(43); 
  
  val search = new Search(initialState);System.out.println("""search  : main.Search = """ + $show(search ));$skip(24); val res$0 = 
  
  search.Traverse(1);System.out.println("""res0: List[main.State] = """ + $show(res$0));$skip(20); 
  
  val target = 4;System.out.println("""target  : Int = """ + $show(target ));$skip(83); 
  
 	val filtered = search.Traverse.filter( list => isMatchingStates(target,list));System.out.println("""filtered  : scala.collection.immutable.Stream[List[main.State]] = """ + $show(filtered ));$skip(59); val res$1 = 
  
  
  filtered(0).filter(x => isMatchingState(target,x));System.out.println("""res1: List[main.State] = """ + $show(res$1))}
    
}