package gof.structural.adapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
class WireCap {
	WireCap link = WireCap.LooseCap;
	private Wire wire;
	
	public static WireCap LooseCap = new WireCap(null);

	public WireCap(Wire wire) {
		this.wire = wire;
	}

	public void addLinkTo(WireCap link) {
		this.link = link;
	}

	public Wire getWire() {
		return wire;
	}

	public String toString() {
		if (link.equals(WireCap.LooseCap))
			return "WireCap belonging to LooseCap";
		return "WireCap belonging to " + wire + " is linked to " + link.getWire();
	}

	public WireCap getLink() {
		return link;
	}
}

class Wire {
	private String name;
	private WireCap left;
	private WireCap right;

	public Wire(String name) {
		this.name = name;
		this.left = new WireCap(this);
		this.right = new WireCap(this);
	}

	public void linkLeftTo(Wire link) {
		left.addLinkTo(link.getRightWireCap());
		link.getRightWireCap().addLinkTo(left);
	}

	public WireCap getRightWireCap() {
		return right;
	}

	public void printWireConnectionsToRight() {
		Wire wire = this;
		while (wire.hasLinkedRightCap()) {
			wire.printRightCap();
			wire = wire.getRightLink();
		}
	}

	public Wire getRightLink() {
		return getRightWireCap().getLink().getWire();
	}

	public void printRightCap() {
		System.out.println(getRightWireCap());
	}

	public boolean hasLinkedRightCap() {
		return !getRightWireCap().link.equals(WireCap.LooseCap);
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Wire " + name;
	}
}

class USBPort {
	public final Wire wireRed = new Wire("USB Red5V");
	public final Wire wireWhite = new Wire("USB White");
	public final Wire wireGreen = new Wire("USB Green");
	public final Wire wireBlack = new Wire("USB Black");
}

interface PS2Device{
	static final String GND = "PS/2 GND";
	static final String BLUE = "PS/2 Blue";
	static final String BLACK = "PS/2 Black";
	static final String GREEN = "PS/2 Green";
	static final String WHITE = "PS/2 White";
	static final String _5V = "PS/2 5V";

	public List<Wire> getWires();
	public void printWiresConnectionsToRight();
}

class PS2Keyboard implements PS2Device {

	public final List<Wire> wires = Arrays.asList(
		new Wire(_5V), 
		new Wire(WHITE), 
		new Wire(GREEN), 
		new Wire(BLACK), 
		new Wire(BLUE), 
		new Wire(GND));

	public List<Wire> getWires() {
		return Collections.unmodifiableList(wires);
	}

	public void printWiresConnectionsToRight() {
		for(Wire wire : wires)
			wire.printWireConnectionsToRight();
	}
}

interface USBDevice {
	public void plugInto(USBPort port);
}

class PS2ToUSBAdapter implements USBDevice {
	private PS2Device device;

	public PS2ToUSBAdapter(PS2Device device) {
		this.device = device;
	}

	public void plugInto(USBPort port) {
		List<Wire> ps2wires = device.getWires();
		Wire wireRed = getWireWithNameFromList(PS2Device._5V, ps2wires);
		Wire wireWhite = getWireWithNameFromList(PS2Device.WHITE, ps2wires);
		Wire wireGreen = getWireWithNameFromList(PS2Device.GREEN, ps2wires);
		Wire wireBlack = getWireWithNameFromList(PS2Device.GND, ps2wires);

		port.wireRed.linkLeftTo(wireRed);
		port.wireWhite.linkLeftTo(wireWhite);
		port.wireGreen.linkLeftTo(wireGreen);
		port.wireBlack.linkLeftTo(wireBlack);

		device.printWiresConnectionsToRight();
	}

	private Wire getWireWithNameFromList(String name, List<Wire> ps2wires) {
		return ps2wires.stream()
						.filter(x -> name.equals(x.getName()))
						.findAny()
						.orElse(null);
	}
}

public class Main
{
	public static void main (String[] args)
	{
		USBDevice adapter = new PS2ToUSBAdapter(new PS2Keyboard());
		adapter.plugInto(new USBPort());
	}
}
