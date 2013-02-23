package main

abstract class State {
  def neighbours : List[State]
}