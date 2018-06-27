package chapter5.tco;

import static cyclops.control.Trampoline.done;
import static cyclops.control.Trampoline.more;

import java.math.BigInteger;

import cyclops.control.Trampoline;

public class Main {
	
	public void fib() {
	    for(int i=0;i<100_000;i++)
	       System.out.println(fibonacci(BigInteger.valueOf(i), BigInteger.ZERO, BigInteger.ONE).get());
	}

	public Trampoline<BigInteger> fibonacci(BigInteger count, BigInteger a, BigInteger b) 	{
	     return  count.equals(BigInteger.ZERO) ?  done(a) : more(()->fibonacci (count.subtract(BigInteger.ONE), b, a.add(b)));
	} 

	public static void main(String[] args) {
		new Main().fib();
	}
}
