package core.server.net;

public class MessageHandler implements Runnable {

	private MessageQueue messages;

	public MessageHandler(MessageQueue messages) {
		this.messages = messages;
	}

	public void run() {
		while (true) {
			try {
				Message message = messages.dequeue();				
				Messenger.send(message.getMessage(), message.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
