package main

abstract class Expression {
  def value: Int
  override def toString() = value.toString()
}

class Num(i : Int) extends Expression  {
  def value = i
}

class Addition(x: Expression, y: Expression) extends Expression { 
  def value = x.value + y.value
  override def toString() = "(" + x.toString() + " + " + y.toString() + ")"
}

class Subtraction(x: Expression, y: Expression) extends Expression {
  def value = x.value - y.value
  override def toString() = "(" + x.toString() + " - " + y.toString() + ")"
}

class Multiplication(x: Expression, y: Expression) extends Expression {
  def value = x.value * y.value
  override def toString() = "(" + x.toString() + " * " + y.toString() + ")"
}

class Division(x: Expression, y: Expression) extends Expression {
  def value = x.value / y.value
  override def toString() = "(" + x.toString() + " / " + y.toString() + ")"
}
