package core.net.server;

import java.io.IOException;
import java.net.InetAddress;

public class MessageWorker implements Runnable {

	private Message message;
	private UserPool userPool;

	public MessageWorker(Message message, UserPool userPool) {
		this.message = message;
		this.userPool = userPool;
	}

	public void run() {
		String msg = message.getMessage();
		InetAddress address = message.getAddress();
		int port = message.getPort();
		User user = userPool.addUser(address, port); // hashtable will be better instead of for to search TODO

		try {
			Messenger.send(msg, user);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
