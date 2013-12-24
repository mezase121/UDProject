package core.net.client;

import java.net.DatagramPacket;

import core.net.data.MessageQueue;

public class Listener implements Runnable {

	private MessageQueue messages;

	private byte[] input;
	private String received;

	public Listener(MessageQueue messages) {
		this.messages = messages;
	}

	public void run() {
		while (true) {
			//if (received == null) { //make null once processed
			try {
				input = new byte[256];
				DatagramPacket packet = new DatagramPacket(input, input.length);
				Client.socket.receive(packet);

				received = new String(packet.getData(), 0, packet.getLength());
				messages.enqueue(new Message(received));
				//System.out.println("Client received: " + "[msg=" + received + "]");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//}
		}
	}

}
