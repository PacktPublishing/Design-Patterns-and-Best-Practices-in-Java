package com.factory.staticfactory;

public class VehicleFactory {
	
	public enum VehicleType{
		Bike,Car,Truck
	}
	
	public static Vehicle create(VehicleType type){
		
		if (type.equals(VehicleType.Bike))
			return new Bike();
		if (type.equals(VehicleType.Car))
			return new Car();
		if (type.equals(VehicleType.Truck))
			return new Truck();

		else return null;
	}
}

abstract class Vehicle {
    //abstract Vehicle class
}

class Bike extends Vehicle{
	//Bike implementation of vehicle
}

class Car extends Vehicle{
	//Car implementation of vehicle
}

class Truck extends Vehicle{
	//Bike implementation of vehicle
}