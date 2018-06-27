package com.factory.factorymethod;

public class Mycode {
	
	public static void main (String s[]) {
		VehicleFactory bikeFactory = new VehicleFactory() {			
			@Override
			protected Vehicle createVehicle(String size) {
						
				if (size.equals("small"))
					return new MountainBike();
				else if (size.equals("large"))
					return new CityBike();		
						
				return null;
			}
		};
		Vehicle bike= bikeFactory.orderVehicle("large", "blue");
		System.out.println("bike.color:"+bike.color);
	}

}

abstract class Bike extends Vehicle{
	
}

class MountainBike extends Bike{
	
}

class CityBike extends Bike{
	
}