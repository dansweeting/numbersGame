package main

abstract class Expression {
  def value: Int
  override def toString() = value.toString()
}

abstract class BinaryExpression extends Expression {
  def lhs: Expression
  def rhs: Expression
}

class Num(i : Int) extends Expression  {
  def value = i
}

class Addition(val lhs: Expression, val rhs: Expression) extends BinaryExpression { 
  def value = lhs.value + rhs.value
  override def toString() = "(" + lhs.toString() + " + " + rhs.toString() + ")"
}

class Subtraction(val lhs: Expression, val rhs: Expression) extends BinaryExpression {
  def value = lhs.value - rhs.value
  override def toString() = "(" + lhs.toString() + " - " + rhs.toString() + ")"
}

class Multiplication(val lhs: Expression, val rhs: Expression) extends BinaryExpression {
  def value = lhs.value * rhs.value
  override def toString() = "(" + lhs.toString() + " * " + rhs.toString() + ")"
}

class Division(val lhs: Expression, val rhs: Expression) extends BinaryExpression {
  def value = lhs.value / rhs.value
  override def toString() = "(" + lhs.toString() + " / " + rhs.toString() + ")"
}
