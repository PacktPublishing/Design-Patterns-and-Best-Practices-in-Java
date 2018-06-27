package com.singleton;

public class Singleton
{
	private static Singleton instance;
	
	private Singleton(){
		System.out.println("Singleton is Instantiated.");
	}

	public static Singleton getInstance()
	{
		if (instance == null)
			instance = new Singleton();

		return instance;
	}

	public void doSomething(){
		System.out.println("Something is Done.");
	}
}
