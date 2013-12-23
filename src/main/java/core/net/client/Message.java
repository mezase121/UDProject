package core.net.client;

import java.net.InetAddress;

import core.net.data.PlainMessage;

public class Message implements PlainMessage {

	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public InetAddress getAddress() {
		return null;
	}

	public int getPort() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "[msg=" + message + "]";
	}
	
}
