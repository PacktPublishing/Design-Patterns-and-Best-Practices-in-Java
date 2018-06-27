package com.factory.factorymethod;


public abstract class VehicleFactory {

	protected abstract Vehicle createVehicle(String item);
	
	public Vehicle orderVehicle(String size, String color)
	{
		Vehicle vehicle = createVehicle(size);
		
		vehicle.testVehicle();
		vehicle.setColor(color);
		
		return vehicle;
	}
}

abstract class Vehicle {
	String color;
    //abstract Vehicle class
	public void testVehicle() {
		// implementation here 
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
}