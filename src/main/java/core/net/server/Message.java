package core.net.server;

import java.net.InetAddress;

import core.net.data.PlainMessage;

public class Message implements PlainMessage {
	
	private InetAddress address;
	private int port;
	private String message;
	
	public Message(String message, InetAddress packetAddress, int packetPort){
		this.message = message;
		this.address = packetAddress;
		this.port = packetPort;
	}

	public InetAddress getAddress() {
		return address;
	}

	public int getPort() {
		return port;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "Message [address=" + address + ", port=" + port + ", message=" + message + "]";
	}	
}
