package core.net.server;

import java.io.IOException;
import java.net.InetAddress;

import core.net.data.PlainMessage;

public class MessageWorker implements Runnable {

	private PlainMessage message;
	private UserPool userPool;

	public MessageWorker(PlainMessage message, UserPool userPool) {
		this.message = message;
		this.userPool = userPool;
	}

	public void run() {
		String msg = message.getMessage();
		InetAddress address = message.getAddress();
		int port = message.getPort();
		User user = userPool.addUser(address, port); // hashtable will be better instead of for to search TODO
		
		System.out.println("Server received: " + "[msg=" + msg+", user="+user.getId()+"]");

		try {
			Messenger.send(msg, user);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
