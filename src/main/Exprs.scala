package main

abstract class Expression {
  def value: Int
  
  override def toString() = value.toString()
  
  def Plus(x : Expression) : Expression = {
	new Addition(this,x)
  }
  
  def Minus(x: Expression) : Expression = {
    new Subtraction(this,x)
  }
  
  def Times(x: Expression) : Expression = {
    new Multiplication(this,x)
  }
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