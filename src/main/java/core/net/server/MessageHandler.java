package core.net.server;

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
				Message message = messages.dequeue();
				new Thread(new MessageWorker(message, userPool)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
