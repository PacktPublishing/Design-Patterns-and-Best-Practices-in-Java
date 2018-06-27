package com.chapter3.interpreter;

import java.util.Stack;

public class Evaluator{
    
    public float evaluate(String expression) {
        Stack<Expression> stack = new Stack<Expression>();
        float result =0;
        for (String token : expression.split(" ")) {
            if  (isOperator(token)) {
            	Expression exp = null;
            	if(token.equals("+"))
            		exp = stack.push(new Plus(stack.pop(), stack.pop()));
            	else if (token.equals("-"))
            		exp = stack.push(new Minus(stack.pop(), stack.pop()));
            	if(null!=exp) {
            		result = exp.interpret();
            		stack.push(new Number(result));
            	}
            }
            if  (isNumber(token)) {
                stack.push(new Number(Float.parseFloat(token)));
            }
        }
        return result;
        
    }
 
    private boolean isNumber(String token) {
		try {
			Float.parseFloat(token);
			return true;
		}
		catch(NumberFormatException nan) {
			return false;
		}
	}

	private boolean isOperator(String token) {
		if(token.equals("+") || token.equals("-"))
			return true;
		return false;
	}
	
	public static void main(String s[]) {
		Evaluator eval = new Evaluator();
		System.out.println(eval.evaluate("2 3 +"));
		System.out.println(eval.evaluate("4 3 -"));
		System.out.println(eval.evaluate("4 3 - 2 +"));
	}

}
