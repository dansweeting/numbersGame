package main

abstract class State {
  def neighbours : Iterable[State]
  def isTarget: Boolean
}