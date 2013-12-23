package core.net.server;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Listener implements Runnable {

	private MessageQueue messages;

	private byte[] input;
	private String received;

	public Listener(MessageQueue messages) {
		this.messages = messages;
	}

	public void run() {
		while (true) {
			try {
				input = new byte[256];
				DatagramPacket packet = new DatagramPacket(input, input.length);
				Server.socket.receive(packet);

				received = new String(packet.getData(), 0, packet.getLength());

				InetAddress packetAddress = packet.getAddress();
				int packetPort = packet.getPort(); //might have to make sure the client uses same port as server.

				messages.enqueue(new Message(received, packetAddress, packetPort));
				System.out.println("Server received: " + "[msg=" + received+"]");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
