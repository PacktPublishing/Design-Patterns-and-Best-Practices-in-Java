package gof.structural.bridge;

public class Main
{
	public static void main (String[] args)
	{
		new MyMessageClient(new WindowsImplementation()).sendMessageToAll("abc@gmail.com", "Test");
	}
}

interface PlatformBridge {
	public void forwardMessage(String msg);
}

class WindowsImplementation implements PlatformBridge {
	public void forwardMessage(String msg) {
		System.out.printf("Sending message \n%s \nFrom the windows machine", msg);
	}
}

class PosixImplementation implements PlatformBridge {
	public void forwardMessage(String msg) {
		System.out.printf("Sending message \n%s \nFrom the linux machine", msg);
	}
}

class MessageSender {
	private PlatformBridge implementation;
	public MessageSender(PlatformBridge implementation) {
		this.implementation = implementation;
	}
	
	public void sendMessage(String from, String to, String body) {
		implementation.forwardMessage(String.format("From : %s \nTo : %s \nBody : %s", from, to, body));
	}
}

class MyMessageClient extends MessageSender {
	private String to = "development_all@abc.com";
	public MyMessageClient(PlatformBridge implementation) {
		super(implementation);
	}

	public void sendMessageToAll(String from, String body) {
		sendMessage(from, to, body);
	}
}
