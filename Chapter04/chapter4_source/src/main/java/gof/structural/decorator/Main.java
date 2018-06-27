package gof.structural.decorator;

import java.util.stream.Collectors;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{	
		final String text = "text";
		final PrintText object = new PrintAsciiText();
		final PrintText printer = new PrintTextHexDecorator(object);
		
		object.print(text);
		printer.print(text);
	}
}

interface PrintText {
	public void print(String text);
} 

class PrintAsciiText implements PrintText {
	public void print(String text) {
		System.out.println("Print ASCII: " + text);
	}
} 

class PrintTextHexDecorator implements PrintText {
	
	private PrintText inner;

	public PrintTextHexDecorator(PrintText inner) {
		this.inner = inner;
	}
	
	public void print(String text) {
		String hex = text.chars()
				.boxed()
	        	.map(x -> "0x" + Integer.toHexString(x))
	 			.collect(Collectors.joining(" "));
		inner.print(text + " -> HEX: " + hex);
	}
}
