package com.chapter3.interpreter;

public class Minus implements Expression {
    Expression left;
    Expression right;

    public Minus(Expression left, Expression right) { 
        this.left = left; 
        this.right = right;
    }

    public float interpret()  { 
        return right.interpret() - left.interpret();
    }
}
