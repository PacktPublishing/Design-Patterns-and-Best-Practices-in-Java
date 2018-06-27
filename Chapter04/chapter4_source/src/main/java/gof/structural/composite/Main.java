package gof.structural.composite;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ArithmethicComposite expr = new MinusOperand(
			new PlusOperand(new NumericValue(1), new NumericValue(4)), 
			new NumericValue(2));
		System.out.printf("Value equals %d\n", expr.getValue());
	}
}

interface ArithmethicComposite {
	
	public int getValue();
}

class NumericValue implements ArithmethicComposite {
	private int value;

	public NumericValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

abstract class ArithmethicOperand implements ArithmethicComposite {
	protected ArithmethicComposite left;
	protected ArithmethicComposite right;

	public ArithmethicOperand(ArithmethicComposite left, ArithmethicComposite right) {
		this.left = left;
		this.right = right;
	}
}

class PlusOperand extends ArithmethicOperand {
	public PlusOperand(ArithmethicComposite left, ArithmethicComposite right) {
		super(left, right);
	}

	public int getValue() {
		return left.getValue() + right.getValue();
	}
}

class MinusOperand extends ArithmethicOperand {
	public MinusOperand(ArithmethicComposite left, ArithmethicComposite right) {
		super(left, right);
	}

	public int getValue() {
		return left.getValue() - right.getValue();
	}
}
