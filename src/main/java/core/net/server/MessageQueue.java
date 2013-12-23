package core.net.server;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

	private LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<Message>();

	public void enqueue(Message msg) throws InterruptedException {
		messages.put(msg);
	}

	public Message dequeue() throws InterruptedException {
		return messages.take();
	}

}
