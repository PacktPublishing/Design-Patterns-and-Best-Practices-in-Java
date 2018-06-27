package com.chapter3.iterator;

public class Main {
	
	public static void main(String s[]){
		String arr[]= {"a", "b", "c", "d"};
		StringArray strarr = new StringArray(arr);
		for (Iterator it = strarr.createIterator(); it.hasNext(); ) 
			   System.out.println(it.next());
	}
}
