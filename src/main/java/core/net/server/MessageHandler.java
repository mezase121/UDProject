package core.net.server;

import core.net.data.MessageQueue;
import core.net.data.PlainMessage;

public class MessageHandler implements Runnable {

	private MessageQueue messages;
	private UserPool userPool;

	public MessageHandler(MessageQueue messages, UserPool userPool) {
		this.messages = messages;
		this.userPool = userPool;
	}

	public void run() {
		while (true) {
			try {
				PlainMessage message = messages.dequeue();
				new Thread(new MessageWorker(message, userPool)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
