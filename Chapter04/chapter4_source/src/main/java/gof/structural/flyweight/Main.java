package gof.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		World world = new World();
		world.get3DObject(_3DObjectTypes.Cube).makeVisible().move(10d, -13.3d, 90.0d);
		world.get3DObject(_3DObjectTypes.Sphere).makeVisible().move(11d, -12.9d, 90.0d);
		world.get3DObject(_3DObjectTypes.Cube).makeVisible().move(9d, -12.9d, 90.0d);
	}
}

enum _3DObjectTypes {
	Cube,
	Sphere
}

class PhysicsEngine {
	public void animateCollision(_3DObject collider, _3DObject collidee) {
		System.out.println("Animate Collision between " + collider + " and " + collidee);
	}
}

class World {
	private PhysicsEngine engine = new PhysicsEngine();
	private Map<String, _3DObject> objects = new ConcurrentHashMap<>();
	private Map<String, Location> locations = new ConcurrentHashMap<>();
	
	public _3DObject get3DObject(_3DObjectTypes type) {
		String name = type.toString();
		if (objects.containsKey(name))
			return objects.get(name);
		_3DObject obj = make3DObject(type);
		objects.put(obj.getName(), obj);
		return obj;
	}


	private _3DObject make3DObject(_3DObjectTypes type) {
		switch (type) {
		case Cube:
			return new Cube(this, type.toString());
		case Sphere:
			return new Sphere(this, type.toString());
		default:
			return new _3DObject(this, type.toString());
		}
	}


	public void move(_3DObject obj, Location location) {
		final List<String> nearObjectNames = getNearObjects(location);
		locations.put(obj.getName(), location);
		
		for (String nearObjectName: nearObjectNames) {
			engine.animateCollision(objects.get(nearObjectName), obj);
		}
	}


	private List<String> getNearObjects(Location location) {
		if (objects.size() < 2)
			return new ArrayList<>();
		return objects.values().stream()
				.filter(obj -> {
					Location loc = locations.get(obj.getName());
					return loc != null && loc.isNear(location, 1);
				})
				.map(obj -> obj.getName())
		        .collect(Collectors.toList());
	}

}

class _3DObject {
	private World world;
	private String name;
	
	public _3DObject(World world, String name) {
		this.world = world;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public _3DObject makeVisible() {
		return this;
	}

	public void move(double x, double y, double z) {
		System.out.println("Moving object " + name + " in the world");
		world.move(this, new Location(x, y, z));
	}
}

class Cube extends _3DObject {

	public Cube(World world, String name) {
		super(world, name);
	}
}

class Sphere extends _3DObject {

	public Sphere(World world, String name) {
		super(world, name);
	}
}

class Location {
	public Location(double x, double y, double z) {
		super();
	}
	
	public boolean isNear(Location location, int radius) {
		return true;
	}
}
