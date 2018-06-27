package com.factory.factorymethod;

public class CarFactory extends VehicleFactory {

	@Override
	protected Vehicle createVehicle(String size) {
		
		if (size.equals("small"))
			return new SportCar();
		else if (size.equals("large")) 
			return new SedanCar();
		
		return null;
	}
}

abstract class Car extends Vehicle{
	
}

class SportCar extends Car{
	
}

class SedanCar extends Car{
	
}
