package gof.structural.facade;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		CoffeeMachineFacade facade = new SuperstarCoffeeMachine();
		facade.serveCoffee();
	}
}

class GroundCoffee {
}

class Water {
}

class CoffeeCup {
}

interface CoffeeMachineFacade {

	public CoffeeCup serveCoffee() throws Exception;
}

interface CoffeeGrinder {

	public void startGrinding();

	public GroundCoffee stopGrinding();
}

interface CoffeeMaker {
	public void pourWater(Water water);
	
	public void placeCup(CoffeeCup cup);

	public void startBrewing(GroundCoffee groundCoffee);

	public CoffeeCup finishBrewing();
}

class SuperstarCoffeeGrinder  implements CoffeeGrinder {

	public void startGrinding() {
		System.out.println("Grinding...");
	}

	public GroundCoffee stopGrinding () {
		System.out.println("Done grinding");
		return new GroundCoffee();
	}
}

class SuperstarCoffeeMaker implements CoffeeMaker {
	public CoffeeCup finishBrewing() {
		System.out.println("Done brewing. Enjoy!");
		return null;
	}

	@Override
	public void pourWater(Water water) {
		System.out.println("Pouring water...");
	}

	@Override
	public void placeCup(CoffeeCup cup) {
		System.out.println("Placing the cup...");
	}

	@Override
	public void startBrewing(GroundCoffee groundCoffee) {
		System.out.println("Brewing...");
	}
}


class SuperstarCoffeeMachine implements CoffeeMachineFacade {

	public CoffeeCup serveCoffee() throws InterruptedException {
		CoffeeGrinder grinder = new SuperstarCoffeeGrinder();
		CoffeeMaker brewer = new SuperstarCoffeeMaker();
		CoffeeCup cup = new CoffeeCup();
		
		grinder.startGrinding();
		Thread.sleep(500);//wait for grind size coarse

		brewer.placeCup(cup);
		brewer.pourWater(new Water());
		brewer.startBrewing(grinder.stopGrinding());
		Thread.sleep(1000);//wait for the brewing process
	
		return brewer.finishBrewing();
	}
}
