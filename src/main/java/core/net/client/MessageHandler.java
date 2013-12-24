package core.net.client;

import core.net.data.MessageQueue;
import core.net.data.PlainMessage;

public class MessageHandler implements Runnable {

	private MessageQueue messages;

	public MessageHandler(MessageQueue messages) {
		this.messages = messages;
	}

	public void run() {
		while (true) {
			try {
				PlainMessage message = messages.dequeue();
				
				System.out.println("Client received: "+message.toString());
				
				//do something with the received data
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
