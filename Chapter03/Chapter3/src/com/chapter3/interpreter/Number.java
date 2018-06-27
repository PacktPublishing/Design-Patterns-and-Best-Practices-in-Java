package com.chapter3.interpreter;

public class Number implements Expression {
	private float number;

	public Number(float number) {
		this.number = number;
	}

	public float interpret() {
		return number;
	}
}
