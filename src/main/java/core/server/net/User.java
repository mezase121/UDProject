package core.server.net;

import java.io.IOException;
import java.net.InetAddress;

public class User {
	
	private InetAddress address;
	private int port;
	private int id;

	public User(InetAddress address, int port, int id) {
		this.address = address;
		this.port = port;
		this.id = id;
	}
	
	public void send(String message){
		try {
			Messenger.send(message, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InetAddress getAddress() {
		return address;
	}

	public int getPort() {
		return port;
	}

	public int getId() {
		return id;
	}
}
