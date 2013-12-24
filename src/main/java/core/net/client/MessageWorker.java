package core.net.client;

import java.io.IOException;
import java.net.InetAddress;

import core.net.data.PlainMessage;

public class MessageWorker implements Runnable {

	private PlainMessage message;

	public MessageWorker(PlainMessage message) {
		this.message = message;
	}

	public void run() {
		String msg = message.getMessage();
		
		System.out.println("Client received: "+message.toString());

	}
}
