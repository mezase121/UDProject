package core.server.net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Listener implements Runnable {

	private MessageQueue messages;
	private UserPool userPool;

	private byte[] input;
	private String received;

	public Listener(MessageQueue messages, UserPool userPool) {
		this.messages = messages;
		this.userPool = userPool;
	}

	public void run() {
		while (true) {
			try {
				input = new byte[256];
				DatagramPacket packet = new DatagramPacket(input, input.length);
				Server.socket.receive(packet);

				received = new String(packet.getData(), 0, packet.getLength());

				InetAddress userAddress = packet.getAddress();
				int userPort = packet.getPort(); //might have to make sure the client uses same port as server.
				User user = userPool.addUser(userAddress, userPort);

				messages.enqueue(new Message(received, user));
				System.out.println("Server received: " + "[msg=" + received + ", user=" + user.getId() + "]");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
