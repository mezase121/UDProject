package core.net.data;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

	private LinkedBlockingQueue<PlainMessage> messages = new LinkedBlockingQueue<PlainMessage>();

	public void enqueue(PlainMessage msg) throws InterruptedException {
		messages.put(msg);
	}

	public PlainMessage dequeue() throws InterruptedException {
		return messages.take();
	}

}
